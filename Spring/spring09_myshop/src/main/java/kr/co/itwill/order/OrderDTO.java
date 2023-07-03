package kr.co.itwill.order;

public class OrderDTO {
	private String orderno;
	private String id;
	private int totalamount;
	private String payment;
	private String receiver;
	private String rece_address;
	private String message;
	private String orderstate;
	private String orderdate;

	public OrderDTO() {
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getRece_address() {
		return rece_address;
	}

	public void setRece_address(String rece_address) {
		this.rece_address = rece_address;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderno=" + orderno + ", id=" + id + ", totalamount=" + totalamount + ", payment=" + payment
				+ ", receiver=" + receiver + ", rece_address=" + rece_address + ", message=" + message + ", orderstate="
				+ orderstate + ", orderdate=" + orderdate + "]";
	}

	
}
