package unibrasil.pp.crawler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WebCrawlerModel implements AbstractEntity{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

		@Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = true)
    private String data;

    @Column(nullable = true)
    private String cidade;

    @Column(nullable = true)
    private String confirmado;

    @Column(nullable = true)
    private String confirmado100k;

    @Column(nullable = true)
    private String obito;

    @Column(nullable = true)
    private String letalitade;

    @Column(nullable = true)
    private String obito100k;



    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return String return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return String return the confirmado
     */
    public String getConfirmado() {
        return confirmado;
    }

    /**
     * @param confirmado the confirmado to set
     */
    public void setConfirmado(String confirmado) {
        this.confirmado = confirmado;
    }

    /**
     * @return String return the confirmado100k
     */
    public String getConfirmado100k() {
        return confirmado100k;
    }

    /**
     * @param confirmado100k the confirmado100k to set
     */
    public void setConfirmado100k(String confirmado100k) {
        this.confirmado100k = confirmado100k;
    }

    /**
     * @return String return the obito
     */
    public String getObito() {
        return obito;
    }

    /**
     * @param obito the obito to set
     */
    public void setObito(String obito) {
        this.obito = obito;
    }

    /**
     * @return String return the letalitade
     */
    public String getLetalitade() {
        return letalitade;
    }

    /**
     * @param letalitade the letalitade to set
     */
    public void setLetalitade(String letalitade) {
        this.letalitade = letalitade;
    }

    /**
     * @return String return the obito100k
     */
    public String getObito100k() {
        return obito100k;
    }

    /**
     * @param obito100k the obito100k to set
     */
    public void setObito100k(String obito100k) {
        this.obito100k = obito100k;
    }

}
