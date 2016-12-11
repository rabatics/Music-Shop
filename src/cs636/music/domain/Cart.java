package cs636.music.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	private Set<LineItem> items;
    /**
     * Construct a new Cart to hold items  
     */
	public Cart() {
		items = new HashSet<LineItem>();
	}
	
    /**
     * Obtain all items in this cart
      
     */
	public Set<LineItem> getItems() {
		return items;
	}
	
	/**
	 * Find an item of this cart through its product id.
	  
	 */
	public LineItem findItem(Product product) {
		
		long prodId = product.getId(); 

		for (LineItem l : items) {
			if (l.getProduct().getId() == prodId) {
				return l;
			}
		}
		return null;
	}

	/**
	 * Add an item into this cart. 
	 * If the item already exists in the cart, only the quantity is changed. 
	
	 */
	public void addItem(LineItem item) {
		
		long prodId = item.getProduct().getId();
		int quantity = item.getQuantity();

		for (LineItem l : items) {

			if (l.getProduct().getId() == prodId) {
				l.setQuantity(quantity);
				return;
			}
		}
		
		items.add(item);
	}

	/**
	 * Remove an item with given product id from this cart 
	 
	 */
	public void removeItem(Product product) {
		long prodId = product.getId(); 

		for (LineItem l : items) {
			if (l.getProduct().getId() == prodId) {
				items.remove(l);
				return;
			}
		}
	}
	

	/**
	 * clean out cart (for end of checkout)
	 */
	public void clear() {
		items.clear();
	}
}