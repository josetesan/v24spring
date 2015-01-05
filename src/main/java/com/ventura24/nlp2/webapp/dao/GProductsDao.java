package com.ventura24.nlp2.webapp.dao;

import com.ventura24.nlp2.webapp.model.GProduct;

import java.util.List;

/**
 * Created by jsanc on 5/01/15.
 */
public interface GProductsDao
{
    public List<GProduct> findGProductsByUser(final Long userId);
}
