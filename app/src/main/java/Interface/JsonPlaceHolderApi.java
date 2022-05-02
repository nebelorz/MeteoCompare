package Interface;

import java.util.List;

import Modelo.Model200;
import Modelo.PrediccionMunicipio;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    // API KEY
    // ?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuZWJlbG9yekBob3RtYWlsLmNvbSIsImp0aSI6IjE0Y2M2ODMyLTA0ZjUtNDMzYS1iODkzLTBjMTlkMWU4MDg4ZSIsImlzcyI6IkFFTUVUIiwiaWF0IjoxNjUwNTY1MjYzLCJ1c2VySWQiOiIxNGNjNjgzMi0wNGY1LTQzM2EtYjg5My0wYzE5ZDFlODA4OGUiLCJyb2xlIjoiIn0.2ERs6mrPbDOgnGUcUZaNPLQHw0f3MwxODMurBZUG6Tc
    @GET
    Call<Model200> getModel200 (@Url String url);

    // URL
    // https://opendata.aemet.es/
    @GET
    Call<List<PrediccionMunicipio>> getPrediccion(@Url String url);
}
