package unibrasil.pp.crawler.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WebCrawlerModel implements AbstractEntity{
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
}
