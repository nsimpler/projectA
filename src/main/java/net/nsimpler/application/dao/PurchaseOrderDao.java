package net.nsimpler.application.dao;

import org.springframework.stereotype.Repository;

import net.nsimpler.application.model.PurchaseOrder;

@Repository
public interface PurchaseOrderDao {

	void save(PurchaseOrder order);

}
