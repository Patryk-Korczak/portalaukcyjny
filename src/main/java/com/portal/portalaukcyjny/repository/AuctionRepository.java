package com.portal.portalaukcyjny.repository;

import com.portal.portalaukcyjny.entity.Auction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuctionRepository extends PagingAndSortingRepository<Auction, Integer> {
    Page<Auction> findAllByActive(int active, Pageable auctionsPage);
}
