package com.portal.portalaukcyjny.controller;

import com.portal.portalaukcyjny.entity.Auction;
import com.portal.portalaukcyjny.repository.AuctionRepository;
import com.portal.portalaukcyjny.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@Controller
@RequestMapping(path="/auction")
public class AuctionController {
    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/getAuctionsPage")
    public @ResponseBody Page<Auction> getAuctionsPage(@RequestParam Integer pageNumber,
                                            @RequestParam Integer pageSize) {
        Pageable auctionsPage = PageRequest.of(pageNumber, pageSize);

        return auctionRepository.findAllByActive(Boolean.TRUE, auctionsPage);
    }

    @GetMapping(path="/getAuction")
    public @ResponseBody
    Optional<Auction> getAuction(@RequestParam Integer auctionId){
        return auctionRepository.findById(auctionId);
    }

    @PutMapping(path="/closeAuction")
    public @ResponseBody String closeAuction(@RequestParam Integer auctionId) {
        auctionRepository.findById(auctionId).map(auction -> {
            auction.setActive(Boolean.FALSE);
            return auctionRepository.save(auction);
        });
        return "OK";
    }





}
