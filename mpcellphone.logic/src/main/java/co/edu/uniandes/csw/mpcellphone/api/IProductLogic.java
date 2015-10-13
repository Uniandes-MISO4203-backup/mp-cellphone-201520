package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.ProductDTO;
import java.util.List;

public interface IProductLogic {
    public int countProducts();
    public List<ProductDTO> getProducts(Integer page, Integer maxRecords);
    public ProductDTO getProduct(Long id);
    public ProductDTO createProduct(ProductDTO dto);
    public ProductDTO updateProduct(ProductDTO dto);
    public void deleteProduct(Long id);
    public List<ProductDTO> findByName(String name);
    public List<ProductDTO> getByCellPhoneName(String name);
    public ProductDTO getCheaperProduct(Long idProvider);
    public ProductDTO getCheaperProvider(Long idCellPhone);
    public List<ProductDTO> getByModel(String model);
    public List<ProductDTO> getByBrand(String brand);
    public List<ProductDTO> getByProviderName(String name);
    public List<ProductDTO> getByCity(String city);
    public List<ProductDTO> getByPriceRange(Long minPrice, Long maxPrice);
    public List<ProductDTO> getByDiscount();
    public List<ProductDTO> getByCategory(String category);
    public List<ProductDTO> getCategories();
    
    public List<ProductDTO> getProductsByProvider(Integer page, Integer maxRecords, Long idProvider);
    public int countProductsByProvider(Long idProvider);
    public ProductDTO getProductByProvider(Long id, Long idProvider);
    public ProductDTO updateProductByProvider(ProductDTO dto, Long idProvider);
    public void deleteProductByProvider(Long id, Long idProvider);
}
