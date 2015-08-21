package co.edu.uniandes.csw.model.api;

import co.edu.uniandes.csw.model.dtos.ProductDTO;
import java.util.List;

public interface IProductLogic {
    public int countProducts();
    public List<ProductDTO> getProducts(Integer page, Integer maxRecords);
    public ProductDTO getProduct(Long id);
    public ProductDTO createProduct(ProductDTO dto);
    public ProductDTO updateProduct(ProductDTO dto);
    public void deleteProduct(Long id);
    public List<ProductDTO> findByName(String name);
}
