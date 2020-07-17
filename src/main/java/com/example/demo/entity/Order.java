package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "ORDER")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;
	@NonNull
	@Column(name = "customer_name")
	private String customerName;
	@NonNull
	@Column(name = "shipping_address")
	private String shippingAddress;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	@CreationTimestamp
	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "total")
	private long total;

	public Order() {
		super();
	}

	@Column(name = "product_code")
	private Long productCode;

	public Order(Long orderId, String customerName, String shippingAddress, List<OrderItem> orderItems, long total) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.shippingAddress = shippingAddress;
		this.orderItems = orderItems;
		this.total = total;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;

	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Long getProductCode() {
		return productCode;
	}

	public void setProductCode(Long productCode) {
		this.productCode = productCode;
	}

	@Override
	public String toString() {
		return "Order [customerName=" + customerName + ", shippingAddress=" + shippingAddress + ", orderItems="
				+ orderItems + ", orderDate=" + orderDate + ", total=" + total + "]";
	}

}
