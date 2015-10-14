package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IClientLogic;
import co.edu.uniandes.csw.mpcellphone.api.ICommentLogic;
import co.edu.uniandes.csw.mpcellphone.api.IProductLogic;
import co.edu.uniandes.csw.mpcellphone.api.IProviderLogic;
import co.edu.uniandes.csw.mpcellphone.api.IQuestionLogic;
import co.edu.uniandes.csw.mpcellphone.api.ICellPhoneLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.CellPhoneDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.CommentDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ProductDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ProviderDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.QuestionDTO;
import co.edu.uniandes.csw.mpcellphone.persistence.CellPhonePersistence;
import co.edu.uniandes.csw.mpcellphone.providers.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;

/**
 * @generated
 */
@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductService {

    @Inject private IProductLogic productLogic;
    @Inject private IProviderLogic providerLogic;
    @Inject private IQuestionLogic questionLogic;
    @Inject private ICommentLogic commentLogic;
    @Inject private ICellPhoneLogic cellPhoneLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;
    @QueryParam("q")
    private String cellPhoneName;
    private ProviderDTO provider = (ProviderDTO) SecurityUtils.getSubject().getSession().getAttribute("Provider");
    
    /**
     * @generated
     */
    @POST
    @StatusCreated
    public ProductDTO createProduct(ProductDTO dto) {
        dto.setProvider(provider);
        return productLogic.createProduct(dto);
    }

    /**
     * Servicio que actualiza las preguntas de los clientes
     * Creado por ggonzalez10
     * @param dto
     * @return 
     */
    @POST
    @Path("/questions/")
    @StatusCreated
    public QuestionDTO createQuestion(QuestionDTO dto) {
        dto.setDate(new java.util.Date());
        return questionLogic.createQuestion(dto);
    }
    
    
    /**
     * Servicio para establecer preguntas sobre un producto..
     * Creado por jh.rubiano10
     */
    @POST
    @Path("/comments/")
    @StatusCreated
    public CommentDTO createComment(CommentDTO dto) {
        return commentLogic.createComment(dto);
    }
    
    /**
     * @generated
     */
    @GET
    public List<ProductDTO> getProducts() {
        if (provider != null) {
            if (page != null && maxRecords != null) {
                this.response.setIntHeader("X-Total-Count", productLogic.countProductsByProvider(provider.getId()));
            }
            return productLogic.getProductsByProvider(page, maxRecords,provider.getId());
        } else {
            if (cellPhoneName != null) {
                return productLogic.getByCellPhoneName(cellPhoneName);
            } else {
                if (page != null && maxRecords != null) {
                    this.response.setIntHeader("X-Total-Count", productLogic.countProducts());
                }
                return productLogic.getProducts(page, maxRecords);
            }
        }
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public ProductDTO getProduct(@PathParam("id") Long id) {
        return productLogic.getProduct(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public ProductDTO updateProduct(@PathParam("id") Long id, ProductDTO dto) {
        if(provider!=null){            
            dto.setId(id);
            return productLogic.updateProduct(dto);
        }else{
             return null;
        }
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteProduct(@PathParam("id") Long id) {
        if(provider!=null){
            productLogic.deleteProduct(id);
        }
    }
    
    /**
     * Servicio para establecer filtros sobre los productos
     * Creado por ma.olivares10
     */
    @GET
    @Path("/cheapest/{id: \\d+}")
    public ProductDTO getCheapestProduct(@PathParam("id") Long idProvider) {
        return productLogic.getCheaperProduct(idProvider);
    }
    
    @GET
    @Path("/cheapestProv/{id: \\d+}")
    public ProductDTO getCheapestProvider(@PathParam("id") Long idCellPhone) {
        return productLogic.getCheaperProvider(idCellPhone);
    }
    
    @Path("/allcomments")    
    @GET
    public List<CommentDTO> getComments(CommentDTO user)
    {
        List<CommentDTO> listComments;
        if (page != null && maxRecords != null)
        {
            this.response.setIntHeader("X-Total-Count", commentLogic.countComment());
        }
        listComments = commentLogic.getComments(page, maxRecords);
        
        return listComments;
    }
    /**
     * Servicio para obtener la lista de modelos
     * Creado por ma.olivares10
     */
    @GET
    @Path("/getModels")
    public List<CellPhoneDTO> getCellPhoneModel() {
        
        return cellPhoneLogic.getCellPhoneModel();
        
        
    }
    /**
     * Servicio para obtener la lista de modelos de un modelo especifico
     * Creado por ma.olivares10
     */
    @GET
    @Path("/getModels/{model}")
    public List<ProductDTO> getByModel(@PathParam("model") String model) {
         
        return productLogic.getByModel(model);
    }
   
    /**
     * Servicio para obtener la lista de marcas
     * Creado por ma.olivares10
     */
    @GET
    @Path("/getBrands")
    public List<CellPhoneDTO> getCellPhoneBrand() {
        
        return cellPhoneLogic.getCellPhoneBrand();
  
    }
    
    /**
     * Servicio para obtener la lista de modelos de un modelo especifico
     * Creado por ma.olivares10
     */
    @GET
    @Path("/getBrands/{brand}")
    public List<ProductDTO> getByBrand(@PathParam("brand") String brand) {
         
        return productLogic.getByBrand(brand);
    }
    /**
     * Servicio para obtener la lista de proveedores 
     * Creado por ma.olivares10
     */
    @GET
    @Path("/getProviders")
    public List<ProviderDTO> getProviders() {
        
        return providerLogic.getProviders();
  
    }
    
    @GET
    @Path("/getProviders/{name}")
    public List<ProductDTO> getByProviderName(@PathParam("name") String name) {
         
        return productLogic.getByProviderName(name);
    }
    /**
     * Servicio para obtener la lista de ciudades
     * Creado por ma.olivares10
     */
    @GET
    @Path("/getCities")
    public List<ProviderDTO> getCities() {
        
        return providerLogic.getCities();
    }
    
    @GET
    @Path("/getCities/{city}")
    public List<ProductDTO> getByCity(@PathParam("city") String city) {
         
        return productLogic.getByCity(city);
    }
    
    /**
     * Servicio para obtener la lista de de filtro por precios
     * Creado por ma.olivares10
     * @param minPrice
     */
    @GET
    @Path("/getByPriceRange/{minPrice}/{maxPrice}")
    public List<ProductDTO> getByPriceRange(@PathParam("minPrice") Long minPrice, @PathParam("maxPrice") Long maxPrice) {
        
        return productLogic.getByPriceRange(minPrice, maxPrice);
    }
    
    /**
     * Servicio para obtener la lista de ciudades
     * Creado por ma.olivares10
     */
    @GET
    @Path("/getDiscount")
    public List<ProductDTO> getByDiscount() {
        
        return productLogic.getByDiscount();
    }
    
    /**
     * Servicio para obtener la lista de ciudades
     * Creado por ma.olivares10
     */
    @GET
    @Path("/getCategories")
    public List<ProductDTO> getCategories() {
        
        return productLogic.getCategories();
    }
    
    /**
     * Servicio para obtener la lista de ciudades
     * Creado por ma.olivares10
     */
    @GET
    @Path("/getCategories/{category}")
    public List<ProductDTO> getByDiscount(@PathParam("category") String category) {
        
        return productLogic.getByCategory(category);
    }
}
