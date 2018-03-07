/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spacewood.sales.skustock;

import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/sku_stock")
public class SkuStockRest {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SkuStockDAL skuStockDAL;         
    
    @RequestMapping(method = RequestMethod.GET)
    public List<SkuStock> findAll(@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) throws SQLException {
        return skuStockDAL.findAll(offset);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SkuStock findById(@PathVariable("id") Integer id) throws SQLException {
        return skuStockDAL.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public SkuStock insert(@RequestBody SkuStock skuStock) {
        return skuStockDAL.insert(skuStock);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public SkuStock update(@RequestBody SkuStock skuStock) {
        return skuStockDAL.update(skuStock);
    }

//    @RolesAllowed("ROLE_SUPER_ADMIN")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) throws Exception {
        skuStockDAL.delete(id);
    }

    @RequestMapping(value = "/find/name", method = RequestMethod.GET)

    public SkuStock findByName(@RequestParam("name") String name) throws Exception {
        return skuStockDAL.findByName(name);
    }
    
    @RequestMapping(value = "/find/name_like", method = RequestMethod.GET)
    public List<SkuStock> findByNameLike(@RequestParam("name") String name) {
        return skuStockDAL.findByNameLike(name);
    }
        
    @RequestMapping(value = "/find_all_list", method = RequestMethod.GET)
    public List<SkuStock> findAllList() {
        return skuStockDAL.findAllList();
    }
}
