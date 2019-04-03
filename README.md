# @MockBean

@MockBean notasyonu springin beanlerine ekleme yapar.Ve mocklama işlemi yapar.@Mock notasyonuda bu işi yapar ancak.@MockBean beanlere ekler.

@RunWith(SpringRunner.class)
@WebMvcTest(UeAuthenticationsApiController.class)
public class InjectMockTest {

  @Autowired private MockMvc mockMvc;

  @MockBean 
  private Vector vector;

  @MockBean 
  private IgniteCache<String, AuthenticationVector> igniteCacheMock;


}
