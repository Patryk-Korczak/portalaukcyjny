package com.portal.portalaukcyjny.controller;

import com.portal.portalaukcyjny.entity.Auction;
import com.portal.portalaukcyjny.repository.AuctionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.portal.portalaukcyjny.utility.Utility.AUCTION_CLOSED;

@CrossOrigin
@Controller
@AllArgsConstructor
@RequestMapping(path="/auction")
public class AuctionController {

    private AuctionRepository auctionRepository;

    @GetMapping(path="/getAuctionsPage")
    public @ResponseBody Page<Auction> getAuctionsPage(@RequestParam Integer pageNumber,
                                                       @RequestParam Integer pageSize) {
        Pageable auctionsPage = PageRequest.of(pageNumber, pageSize);

        return auctionRepository.findAllByActive(1, auctionsPage);
    }

    @GetMapping(path="/getAuction")
    public @ResponseBody
    Optional<Auction> getAuction(@RequestParam Integer auctionId){
        return auctionRepository.findById(auctionId);
    }

    @PutMapping(path="/closeAuction")
    public @ResponseBody String closeAuction(@RequestParam Integer auctionId) {
        auctionRepository.findById(auctionId).map(auction -> {
            auction.setActive(0);
            return auctionRepository.save(auction);
        });
        return AUCTION_CLOSED + auctionId;
    }





}
