package com.ventura24.nlp2.webapp.dao;

import com.ventura24.nlp2.webapp.model.Depot;

import java.util.List;

/**
 * Created by josete on 3/1/15.
 */

public interface DepotRepository {

    List<Depot> findAllByUserid(Long userId);
}
