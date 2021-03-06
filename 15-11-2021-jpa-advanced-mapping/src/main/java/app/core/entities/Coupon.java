package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = { "reviews", "customers" })
@Entity
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "coupon_id") // FK in Review table
	private List<Review> reviews;

	@ManyToMany
	@JoinTable(

			name = "customer_coupon",

			joinColumns = @JoinColumn(name = "coupon_id"),

			inverseJoinColumns = @JoinColumn(name = "customer_id")

	)
	private List<Customer> customers;

	// CTOR
	public Coupon(int id, String title) {
		this(id, title, null, null);
	}

	public void addReview(Review... review) {
		if (this.reviews == null) {
			this.reviews = new ArrayList<>();
		}
		for (Review curr : review) {
			this.reviews.add(curr);
		}
	}

}
