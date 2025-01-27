package az.ingress.service;

import az.ingress.dto.ComputerDto;
import az.ingress.entity.ComputerEntity;
import az.ingress.exception.NotFoundException;
import az.ingress.model.Computer;
import az.ingress.model.criteria.ComputerCriteria;
import az.ingress.model.criteria.PageCriteria;
import az.ingress.response.ComputerResponse;
import az.ingress.model.ComputerStatus;
import az.ingress.repository.ComputerRepository;
import az.ingress.repository.OrderDetailRepository;
import az.ingress.response.PageableResponse;
import az.ingress.specification.ComputerSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static az.ingress.exception.ExceptionConstants.COMPUTER_NOT_FOUND_CODE;
import static az.ingress.exception.ExceptionConstants.COMPUTER_NOT_FOUND_MESSAGE;
import static az.ingress.mapper.PageableMapper.PAGEABLE_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class ComputerServiceImpl implements ComputerService {
    private final ComputerRepository computerRepository;
    private final OrderDetailRepository orderDetailRepository;
    private OrderDetailService orderDetailService;
   private final ComputerCriteria computerCriteria;

    //@Transactional
    @Override
    public void create(Computer computer) {
        log.info("ActionLog.create.start computer: {}", computer);
        computerRepository.save(ComputerEntity.builder()
                .computerMark(computer.getComputerMark())
                .amount(computer.getAmount())
                .date(LocalDate.now())
                .status(ComputerStatus.MACHINE)

                .build());
        log.info("ActionLog.create.end computer: {}", computer);
        // orderDetailService.testing5();//Burada biz ayi bean uzre method qurub order_det table-e sorgu gonderib sorgunu save edirk
        //roolBack olunmayacaq cunki testing5(); methodunda extecption qeyd etmemisik ;
        //+Biz testing5();methodunda new Transactional qeyd etmiyimiz ucun burada computer table sorgumuz save olunmaycaq amaa
        //order-det table-e save olunacaq eger default Transactional qeyd etseydik o zaman her iki sorgumuz roolBack olunacaqgdi;

//throw new RuntimeException("Not cannot ");


        // testing4(computer);
        //  testing2();
        // testing();
/*
        try {
            testing1();
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());//Bu sekilde checked exception-u try catch etsek ,
            // yene sorgularmiz roolBack olunacaq;
            //Yox eger her yerde checked ex throws etsek o zaman verdiyimiz execption gelecek amma kodumuz roolBack olunmayacaq;
            //Transactional yanliz unchecked ex ve checked ex rty catch etiymiz zaman ise dusur ve roolBack olunur eks halda roolBack olunmur;
            //@Transactional(noRollbackFor = )->Eger Runtime Ex meselen versek roolBack etmiyecek;
            //@Transactional(rollbackFor = )->Burda ise checked meselen versek roolBack edecek;
        }


 */
    }


    public void testing() {

        throw new RuntimeException("Not cannot");//Transactional-a unchecked exception verdiyimiz zaman kodumuz roolback olunacaq;
    }

    public void testing1() throws Exception {//Transactional-a checked exception verdiyimiz zaman kodumuz roolback olumayacaq sorgularim save olunacaq;;

        throw new Exception("Not cannot");
    }


    /*@Transactional(propagation = Propagation.REQUIRES_NEW)//Bura biz @Transactional(propagation = Propagation.REQUIRES_NEW)
//Elave etsek bele yene create methodunda olan bir default Transactional ile ise dusecek cunki bir bean ile ferqli iki Transactional
//Islenmir;
    public void testing2() {
        orderDetailRepository.save((OrderDetailEntity.builder()
                .orderName("PhoneOrder")
                .orderAmount(new BigDecimal(55))
                .date(LocalDate.now())
                .build()));

        throw new RuntimeException("Not cannot 2024-18-12");
        //Bu sekilde yazsaq eger Transactional testing2 methodunda cagirsaq onda @Transactional ise dusmuyecek ve roolBack olunmaycaq
        //Sadece exception atcaq ve sorgumuz save olunacaq her iki tablede;
        //Eksine @Transactional create methodunda qoysaq bu zaman @Transactional ise dusecek ve her iki sorgumuz roolBack olunacaq ;
    }

     */

    // @Transactional
    // private void testing3(){}//@Transactional private methodlarda ise dusmur ;
    //Transactional ozu Proxy pater uzerinde qurulub ve isleyir;
    //Proxy @ annotation dedikde biz @Transactional esas nezerde tuta bilerik ;


   /* public void testing4(Computer computer){//Bu sekilde Computer sorgusunu gondersek bele bu zaman @Transactional ise dusmur;
        //Yox eyer bu methoda save sorgusunu gondersek @Transactional crate methodunda qoysaq bu zaman roolBack olunacq;
        computerRepository.save(ComputerEntity.builder()
                .computerMark(computer.getComputerMark())
                .amount(computer.getAmount())
                .date(LocalDate.now())
                .status(ComputerStatus.MACHINE)
                .build());


    }

    */


    @Override
    public void update(Computer computer, Long id) {
        var comp = fetchOrderIfExist(id);
        comp.setComputerMark(computer.getComputerMark());
        comp.setAmount(computer.getAmount());
        computerRepository.save(comp);


    }

    @Override
    public void updateAll(ComputerDto computerDto, Long id) {
        var comp = fetchOrderIfExist(id);
        comp.setComputerMark(computerDto.getComputerMark());
        comp.setAmount(computerDto.getAmount());
        comp.setStatus(ComputerStatus.MACHINE);
        computerRepository.save(comp);
    }

    @Override
    public void delete(Long id) {
        var comp = fetchOrderIfExist(id);
        comp.setStatus(ComputerStatus.RUNNING);
        computerRepository.save(comp);

    }

    // @Override
    // @Cacheable("computer") //Cache edirik ;//Proxy DP esasinda isleyir;
    public ComputerResponse getById(Long id) {
        log.info("ActionLog.getById.start:{}", id);
        var comp = fetchOrderIfExist(id);

        var comp1 = new ComputerResponse(comp.getComputerMark(), comp.getAmount(), comp.getDate());
        log.info("ActionLog.getById.end:{}", id);
        return comp1;
    }

    // @CachePut(value = "computer") //Cache vasitesile soruglarimizi update bu sekilde edirik;
    @Override
    public ComputerResponse updateCache(Long id) {
       return getById(id);}

    // @CacheEvict(value = "computer",allEntries = true)//Bu sekilde cache silirik ;
     @Override
    public void deleteCache() {

    }

    @Override
    public PageableResponse getComputer(ComputerCriteria computerCriteria, PageCriteria pageCriteria) {
        var pageRequest= PageRequest.of(pageCriteria.getPage(), pageCriteria.getCount());
        var specification=new ComputerSpecification(computerCriteria);
        var computersPage=computerRepository.findAll(specification,pageRequest);

        return PAGEABLE_MAPPER.buildPageableResponse(computersPage.getContent(),
                computersPage.getNumber(),
                computersPage.getTotalElements(),
                computersPage.hasNext(),
                computersPage.getTotalPages());
    }

    @Override
    public List<ComputerDto> getAll() {
        return computerRepository.findAll().stream().map(computerEntity -> {
            return ComputerDto.builder()
                    .computerMark(computerEntity.getComputerMark())
                    .amount(computerEntity.getAmount())
                    .date(computerEntity.getDate())
                    .status(computerEntity.getStatus())


                    .build();


        }).toList();


    }

    private ComputerEntity fetchOrderIfExist(Long id) {
        return computerRepository.findByIdAndStatusNot(id, ComputerStatus.RUNNING)

                .orElseThrow(() -> {
                    log.error("ActionLog.fetchOrderIfExist.error post with id:{} not found", id);
                    return new NotFoundException(
                            String.format(COMPUTER_NOT_FOUND_MESSAGE, id), COMPUTER_NOT_FOUND_CODE);


                });
    }
    /*
        @PostConstruct
        public void test() {

            var comp = computerRepository.findByComputerMarkAndDateAfter("Mac", LocalDate.of(2024,12,14)).get();

            System.out.println("Computer Id:" + comp.getId());
        }


    @PostConstruct
    public void fly() {

        var cma = computerRepository.findByComputerMarkAndAmount("Mac", (new BigDecimal("60"))).get();
        System.out.println("Computer:" + cma.getId());


    }

    @PostConstruct
    public void fly1() {
        var id = computerRepository.findByComputerMark("Mac");
        System.out.println("Computer:" + id);
    }

    @PostConstruct
    public void fly2() {

        var id2 = computerRepository.findByAmount(new BigDecimal(60));
        System.out.println("Computer:" + id2);
    }

     */

}
