package com.LoanApplicationService.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerDetailsRepositary extends JpaRepository<com.LoanApplicationService.model.CustomerDetails,Integer> {

}
