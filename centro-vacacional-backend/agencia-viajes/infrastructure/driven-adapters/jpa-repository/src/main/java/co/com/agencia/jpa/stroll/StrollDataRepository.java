package co.com.agencia.jpa.stroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface StrollDataRepository extends JpaRepository<StrollData, Integer>, QueryByExampleExecutor<StrollData> {
}
