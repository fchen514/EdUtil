package com.fchen.ed.miner.dao;

import java.util.Set;

public interface GenericStaticTypeDao<T> {
	public void addAll(Set<T> tSet);
	public void add(T t);
	public Set<T> getAll();
}
