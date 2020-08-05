package PEJ;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PayRepository extends PagingAndSortingRepository<Pay, Long>{
    Pay findByTbId(Long tbId);
}