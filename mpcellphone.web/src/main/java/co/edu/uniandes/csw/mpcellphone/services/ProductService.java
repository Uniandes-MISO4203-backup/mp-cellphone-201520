package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IClientLogic;
import co.edu.uniandes.csw.mpcellphone.api.IProductLogic;
import co.edu.uniandes.csw.mpcellphone.api.IProviderLogic;
import co.edu.uniandes.csw.mpcellphone.api.IQuestionLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ProductDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ProviderDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.QuestionDTO;
import co.edu.uniandes.csw.mpcellphone.providers.StatusCreated;
import static com.sun.enterprise.util.Print.print;
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
    @Inject  private IClientLogic clientLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;
    @QueryParam("q")
    private String cellPhoneName;
    private ProviderDTO provider = (ProviderDTO) SecurityUtils.getSubject().getSession().getAttribute("Provider");
    private final ClientDTO client = (ClientDTO)SecurityUtils.getSubject().getSession().getAttribute("Client");
    /**
     * @generated
     */
    @POST
    @StatusCreated
    public ProductDTO createProduct(ProductDTO dto) {
        return productLogic.createProduct(dto);
    }

    /**
     * Servicio que actualiza las preguntas de los clientes
     * Creado por ggonzalez10
     */
    @POST
    @Path("/questions/")
    @StatusCreated
    public QuestionDTO createQuestion(QuestionDTO dto) {
        return questionLogic.createQuestion(dto);
    }
    /**
     * @generated
     */
    @GET
    public List<ProductDTO> getProducts() {
        if (provider != null) {
            return providerLogic.getProvider(provider.getId()).getProducts();
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
        dto.setId(id);
        return productLogic.updateProduct(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteProduct(@PathParam("id") Long id) {
        productLogic.deleteProduct(id);
    }
}
