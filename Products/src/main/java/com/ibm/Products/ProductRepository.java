package com.ibm.Products;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ProductRepository {
    @Autowired

    JdbcTemplate jdbcTemplate;

    class ProductRowMapper implements RowMapper < Product > {

        @Override

        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

            Product prod = new Product();
            prod.setProductId(rs.getString("productid"));
            
            prod.setProductName(rs.getString("productname"));
            prod.setProductDesc(rs.getString("productdesc"));
           

            return prod;

        }

		

    }

    public List < Product > findAll() {

        return jdbcTemplate.query("select * from product", new ProductRowMapper());

    }

    public Product findById(String id) {

        return jdbcTemplate.queryForObject("select * from product where productid=?", new Object[] {

                id

            },

            new BeanPropertyRowMapper < Product > (Product.class));

    }

    public int deleteById(String id) {

        return jdbcTemplate.update("delete from product where productid=?", new Object[] { id });

    }

    public int insert(Product prod) {

        return jdbcTemplate.update("insert into product (productid, productname, productdesc) " + "values(?,  ?, ?)",

            new Object[] {

              prod.getProductId(),prod.getProductName(),prod.getProductDesc()

            });

    }

    public int update(Product prod) {
		

    /*    return jdbcTemplate.update("update product " + " set name = ? + " where id = ?",

            new Object[] {

              

            });*/
    	return 0;
    }

}
