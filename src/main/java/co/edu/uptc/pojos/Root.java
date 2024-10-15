package co.edu.uptc.pojos;
import lombok.Getter;
import lombok.Setter;

/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */

@Getter
@Setter
public class Root {
    public String region;
    public String c_digo_dane_del_departamento;
    public String departamento;
    public String c_digo_dane_del_municipio;
    public String municipio;

    @Override
    public String toString() {
        return region+" "+c_digo_dane_del_departamento+" "+departamento+" "+c_digo_dane_del_municipio+" "+municipio;
    }
}

