package com.netanel.coupons.jbeans;

import java.io.File;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *Coupon System Coupon JBean Class.
 */
@XmlRootElement
public class Coupon {

	//
	// Attributes
	//
	private long id = -1;
	private String title;
	private LocalDate startDate;
	private LocalDate endDate;
	private int amount;
	private CouponType type;
	private String message;
	private double price;
	public static final String DEFAULT_ICON = "images/default_coupon_icon.png";
	private String image;
	
	//
	// Constructor
	//
	public Coupon() {}
	
	public Coupon(String title, LocalDate startDate, LocalDate endDate, int amount, CouponType type, String message,
			double price, String image) {
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.type = type;
		this.message = message;
		this.price = price;
		setImage(image);
	}
	
	public Coupon(long id, String title, LocalDate startDate, LocalDate endDate, int amount, CouponType type, String message,
			double price, String image) {
		this(title, startDate, endDate, amount, type, message, price, image);
		this.id = id;
	}

	//
	// Functions
	//
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public int getAmount() {
		return amount;
	}

	public CouponType getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

	public double getPrice() {
		return price;
	}

	/**
	 * @return a {@code String} with coupon's icon path.
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @return an {@code Icon} object of the coupon's icon. If no icon was set, returns the default icon.
	 */
	public ImageIcon getIcon() {
		ImageIcon icon = null;
		if (image.equals(DEFAULT_ICON)) {
			icon = new ImageIcon(getClass().getClassLoader().getResource(image));
		} else {
			icon = new ImageIcon(image);
		}
		return icon;
	}
	
	public void setId(long id) {
		if (this.id == -1) { 
			this.id = id;
		} else {
			throw new IllegalArgumentException("ID already set: " + this.id);
		}
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setType(CouponType type) {
		this.type = type;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setImage(String image) {
		if (image == null || image.equals("") || !new File(image).isFile()){
			this.image = DEFAULT_ICON;
		} else {
			this.image = image;
		}	
	}

	/**
	 * Get Coupon details. Used by table model. 
	 * @return an {@code Object[]} array of {@code [long id, String title, LocalDate startDate, LocalDate endDate, int amount, String message, double price, Icon icon]}.
	 */
	public Object[] getDetails(int iconSize) {
		Object[] detail = {getId(), getTitle(), getStartDate(), getEndDate(), getAmount(), getType(), getMessage(), getPrice(),
				new ImageIcon(getIcon().getImage().getScaledInstance(iconSize, iconSize, java.awt.Image.SCALE_SMOOTH))};
		return detail;
	}
	
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", startDate="
				+ startDate + ", endDate=" + endDate + ", amount=" + amount
				+ ", type=" + type + ", message=" + message + ", price="
				+ price + ", image=" + image + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coupon other = (Coupon) obj;
		if (amount != other.amount)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
}

	