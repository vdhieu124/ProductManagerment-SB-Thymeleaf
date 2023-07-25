package com.vietcodedi.onlineshopping.repository;

import com.vietcodedi.onlineshopping.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<Product>(); //Dong vai tro thay the CSDL

    public void createProducts() { //Khoi tao Danh sach voi 3 Product mau
        list = List.of(
                new Product(1, "product 1", 10, 1000),
                new Product(2, "product 2", 20, 2000),
                new Product(3, "product 3", 30, 3000)
        );
    }

    public List<Product> getAllProducts() { //Ham lay ra toan bo Du lieu tu Danh sach
        return list;
    }

    public Product findById(int id){ //Tim kiem san pham theo ID trong Danh sach
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Product> search(String name) { //Tra ve danh sach Product co ten San pham bat dau bang name
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }

    public Product save(Product p) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (p.getId())) {
                return null;
//                break;
            }
        }
        list.add(p);
        return p;
    }

    public String delete(Integer id) { //removeIf: return true neu co phan tu
        list.removeIf(x -> x.getId() == (id));
        return null; //null, true ? String > Java Core
    }

    public Product update(Product product) {
        //Tim kiem
        int idx = -1;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (product.getId())) {
                id = product.getId();
                idx = i; //Tim ra vi tri cua phan tu can Update trong Danh sach
                break;
            }
        }
        if(idx == -1){
            return null;
        }
        list.set(idx, product);
        return product;
    }

}
