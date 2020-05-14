package com.mum.projectx.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mum.projectx.model.Data;
import com.mum.projectx.model.User;
import com.mum.projectx.storage.StorageInterface;

class UserRepository implements UserRepositoryInterface {
  private StorageInterface storage;
  private Data data;

  UserRepository(StorageInterface storage) {
    this.storage = storage;
  }

  private void ensureData() {
    this.data = storage.getData();
  }

  @Override
  public User get(long id) {
    Optional<User> user = getAll().stream().filter(m -> m.getId() == id).findFirst();
    if (user.isPresent()) return user.get();
    return null;
  }

  @Override
  public List<User> getAll() {
    ensureData();
    ArrayList<User> users = new ArrayList<User>();
    users.addAll(Arrays.asList(this.data.getUsers()));
    return users;
  }

  @Override
  public void save(User entity) {
    User user = get(entity.getId());
    if (user != null) {
      // update
      user.setAdmin(entity.isAdmin());
      user.setFullname(entity.getFullname());
      user.setUsername(entity.getUsername());
      user.setPassword(entity.getPassword());
    } else {
      // create
      List<User> users = getAll();
      long maxId = users.stream().mapToLong(u -> (Long)u.getId()).max().orElseGet(() -> 0);
      entity.setId(maxId + 1); 
      users.add(entity);
      // sync data
      this.data.setUsers(users.toArray(new User[users.size()]));
    }
    storage.saveData(this.data);
  }

  @Override
  public User findByUserNameAndPassword(String username, String password) {
    Optional<User> user = getAll().stream().filter(m -> m.getUsername().equals(username) && m.getPassword().equals(password)).findFirst();
    if (user.isPresent()) return user.get();
    return null;
  }

@Override
public User findByUserName(String username) {
	Optional<User> user = getAll().stream().filter(m -> m.getUsername().equals(username)).findFirst();
    if (user.isPresent()) return user.get();
    return null;
}

}