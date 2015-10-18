package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IProductLogic;
import co.edu.uniandes.csw.mpcellphone.converters.ProductConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.ProductDTO;
import co.edu.uniandes.csw.mpcellphone.entities.ProductEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.ProductPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class ProductLogic implements IProductLogic {

    @Inject private ProductPersistence persistence;

    private static final String PARAM1="Not supported yet.";
    /**
     * @generated
     */
    @Override
    public int countProducts() {
        return persistence.count();
    }

    /**
     * @generated
     */
    @Override
    public List<ProductDTO> getProducts(Integer page, Integer maxRecords) {
        return ProductConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    @Override
    public ProductDTO getProduct(Long id) {
        return ProductConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        ProductEntity entity = ProductConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ProductConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public ProductDTO updateProduct(ProductDTO dto) {
        ProductEntity entity = persistence.update(ProductConverter.fullDTO2Entity(dto));
        return ProductConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public void deleteProduct(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    @Override
    public List<ProductDTO> findByName(String name) {
        return ProductConverter.listEntity2DTO(persistence.findByName(name));
    }
    
    /**
     * Return list of cellphone with name matches with param name
     * @param name
     * @return 
     */
    @Override
    public List<ProductDTO> getByCellPhoneName(String name){
        return ProductConverter.listEntity2DTO(persistence.getByCellPhoneName(name));
    }
    
    /**
     * Return the cheapest Product from a provider
     * @param idProvider
     * @return 
     */
    @Override
    public ProductDTO getCheaperProduct(Long idProvider){       
        return ProductConverter.fullEntity2DTO(persistence.getCheaperProduct(idProvider));
    }
    
    /**
     * Return the cheapest provider of a Cellphone model
     * @param idCellPhone
     * @return 
     */
    @Override
    public ProductDTO getCheaperProvider(Long idCellPhone){       
        return ProductConverter.fullEntity2DTO(persistence.getCheaperProvider(idCellPhone));
    }
    /**
     * Para Obtener la lista de un modelo especifico, Desarrollado por Miguel Olivares
     * @param model
     * @return 
     */
    @Override
    public List<ProductDTO> getByModel(String model) {
        return ProductConverter.listEntity2DTO(persistence.getByModel(model));
    }
    /**
     * Para Obtener la lista de productos filtrado por marca, Desarrollado por Miguel Olivares
     * @param brand
     * @return 
     */
    @Override
    public List<ProductDTO> getByBrand(String brand) {
        return ProductConverter.listEntity2DTO(persistence.getByBrand(brand));
    }
    
    /**
     * Para Obtener la lista de productos basado en el nombre de un proveedor, Desarrollado por Miguel Olivares
     * @param name
     * @return 
     */
    @Override
    public List<ProductDTO> getByProviderName(String name) {
        return ProductConverter.listEntity2DTO(persistence.getByProviderName(name));
    }
    /**
     * Para Obtener la lista de un modelo especifico filtrado por ciudad, Desarrollado por Miguel Olivares
     * @param city
     * @return 
     */
    @Override
    public List<ProductDTO> getByCity(String city) {
        return ProductConverter.listEntity2DTO(persistence.getByCity(city));
    }
    //Para Obtener la lista de un modelo especifico filtrado por ciudad, Desarrollado por Miguel Olivares
    @Override
    public List<ProductDTO> getByPriceRange(Long minPrice, Long maxPrice) {
        return ProductConverter.listEntity2DTO(persistence.getByPriceRange(minPrice, maxPrice));
    }
    //Para Obtener la lista de un modelo especifico filtrado por descuento, Desarrollado por Miguel Olivares
    @Override
    public List<ProductDTO> getByDiscount(){
        return ProductConverter.listEntity2DTO(persistence.getByDiscount());
    }
    //Para Obtener la lista de un modelo especifico filtrado por ciudad, Desarrollado por Miguel Olivares
    @Override
    public List<ProductDTO> getByCategory(String category) {
        return ProductConverter.listEntity2DTO(persistence.getByCategory(category));
    }
    
    //Para Obtener la lista de categorias, desarrollado por Miguel Olivares
    @Override
    public List<ProductDTO> getCategories(){
        return ProductConverter.listString2DTO(persistence.getCategories());
        
    }
    /**
     * 
     * @param page
     * @param maxRecords
     * @param idProvider
     * @return 
     */
    @Override
    public List<ProductDTO> getProductsByProvider(Integer page, Integer maxRecords, Long idProvider) {
        return ProductConverter.listEntity2DTO(persistence.getProductsByProvider(page, maxRecords, idProvider));
    }
    
    /**
     * 
     * @param idProvider
     * @return 
     */
    @Override
    public int countProductsByProvider(Long idProvider) {
        return persistence.getCountProductsByProvider(idProvider);
    }
    /**
     * 
     * @param imei
     * @return 
     */
    @Override
    public ProductDTO getProductByImei(String imei){
        return ProductConverter.simpleEntity2DTO(persistence.getProductByImei(imei));
    }     
}