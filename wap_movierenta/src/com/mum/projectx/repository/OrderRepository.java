package com.mum.projectx.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mum.projectx.model.Data;
import com.mum.projectx.model.Order;
import com.mum.projectx.storage.StorageInterface;

class OrderRepository implements OrderRepositoryInterface {
  private StorageInterface storage;
  private Data data;

  OrderRepository(StorageInterface storage) {
    this.storage = storage;
  }
  
  private void ensureData() {
	    this.data = storage.getData();
  }

@Override
  public Order get(long id) {
	Optional<Order> order = getAll().stream().filter(o -> o.getId()==id).findFirst();
    if (order.isPresent()) {
    	return order.get();
    }
    return null;
  }

  @Override
  public List<Order> getAll() {
    ensureData();
    List<Order> orders = new ArrayList<>();
    orders.addAll(Arrays.asList(this.data.getOrders()));
    return orders;
  }

  @Override
  public void save(Order entity) {
    Order order = get(entity.getId());
    if (order!=null) { // update case
    	order.setDateOrdered(entity.getDateOrdered());
    	order.setMovieId(entity.getMovieId());
    	order.setMovieTitle(entity.getMovieTitle());
    	order.setToken(entity.getToken());
    	order.setUserId(entity.getUserId());
    } else { //insert case
    	List<Order> orders = this.getAll();
    	long maxId = orders.stream().mapToLong(u -> (Long)u.getId()).max().orElseGet(() -> 0);
        entity.setId(maxId + 1); 
    	orders.add(entity);
    	this.data.setOrders(orders.toArray(new Order[orders.size()]));
    }
    this.storage.saveData(data);
  }

	@Override
	public Order findByUserIdAndMovieId(long userId, long movieId) {
		Optional<Order> order = getAll().stream().filter(o -> o.getUserId()==userId && o.getMovieId()==movieId).findFirst();
		if (order.isPresent()) {
			return order.get();
		}
		return null;
	}

	@Override
	public Order findByToken(String token) {
		Optional<Order> order = getAll().stream().filter(o -> o.getToken().contentEquals(token)).findFirst();
		if (order.isPresent()) {
			return order.get();
		}
		return null;
	}
	
}