//model object definition
package apispec;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * data model definition
 * API = `<host>/api`
 * METHOD = `GET, POST, PUT, DELETE`
 * HEADERS = `{Authorization: "", hash: ""}`
 * QUERY_PARAMS = `{userdata: {a: 1, b: 2}}`
 */
@Entity
public class ApiSpec {

  @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
  public long getId() { return id;}

	private String api;
  private String method;
  private String headers;
	private String queryParams;

  public String getApi() { return api;}
  public void setApi(String api) {  this.api = api;}

  public String getMethod() { return method;}
	public void setMethod(String method) { this.method = method;}

  public String getHeaders() {return headers;}
  public void setHeaders(String headers) { this.headers = headers;}

  public String getQueryParams() {return queryParams;}
	public void setQueryParams(String queryParams) {  this.queryParams = queryParams;}

  public ApiSpec(){}
  public ApiSpec(String api, String method, String headers, String queryParams) {
    this.api = api;
    this.method = method;
    this.headers = headers;
    this.queryParams = queryParams;
  }
}
