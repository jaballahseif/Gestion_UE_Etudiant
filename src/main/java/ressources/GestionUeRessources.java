package ressources;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
@Path("UE")
public class GestionUeRessources {

    public static UniteEnseignementBusiness uniteEnseignementMetier = new UniteEnseignementBusiness();

    @GET
    @Produces("application/json")
    public Response getUnitesEnseignement(@QueryParam("domaine") String domaine) {
        List<UniteEnseignement> liste = new ArrayList<>();

        if(domaine != null) {
            liste = uniteEnseignementMetier.getUEByDomaine(domaine);
        } else {
            liste = uniteEnseignementMetier.getListeUE();
        }

        if(liste.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.status(Response.Status.OK).entity(liste).build();
    }
}
