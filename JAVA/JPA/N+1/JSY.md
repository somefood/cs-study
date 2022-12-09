> JPA N+1 문제

쿼리문으로 1개의 엔티티를 조회 했는데, 연관관계로 인해 N개의 쿼리문이 발생하는 문제

    public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();


=================================================

    public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;
 



> 즉시 로딩(FetchType.EAGER)

모든 Post를 조회(findAll)할 경우, Comment 클래스에 걸려있는 post의 즉시 로딩으로 인해 post가 1회 조회될 때, N개의 댓글이 함께 조회 된다.



> 지연 로딩(FetchType.LAZY)


지연 로딩을 사용할 경우 즉시 로딩에서 발생한 문제 즉 Post 첫 전체 조회시에는 문제가 발생하지 않는다. 하지만, 이후 Post를 재사용하게 될 경우 문제가 된다. 그 이유는, 첫 조회 이후 Post는 프록시 형태로 캐시에 올라가게 되고 이는 즉시 로딩된 상태와 같게 된다. 그래서 그 이후 댓글과 관련된 조회를 한다면 즉시 로딩에서 발생한 N+1 문제가 반복되게 된다.


- 결론: JPA가 자동적으로 먼저 생성해주는 JPQL을 통해서 우선적으로 쿼리를 만들다보니 연관관계가 걸려있어도 Join이 바로 걸리지 않는다.   


> N+1 문제의 해결책 - fetch join, EntityGraph 어노테이션, Batch Size...




fetch join

fetch join의 경우 지연 로딩이 걸려있는 연관관계에 대해서 한번에 같이 가져오게 해주는(Join) 구문

- @Query("select distinct p from Post p left join fetch p.comments")

EntityGraph 어노테이션


- @EntityGraph(attributePaths = {"comments"}, type = EntityGraphType.FETCH)

    @Query("select distinct p from Post p left join p.comments")


   

참고자료
- https://velog.io/@jinyoungchoi95/JPA-%EB%AA%A8%EB%93%A0-N1-%EB%B0%9C%EC%83%9D-%EC%BC%80%EC%9D%B4%EC%8A%A4%EA%B3%BC-%ED%95%B4%EA%B2%B0%EC%B1%85 
- https://programmer93.tistory.com/83
- https://jojoldu.tistory.com/165