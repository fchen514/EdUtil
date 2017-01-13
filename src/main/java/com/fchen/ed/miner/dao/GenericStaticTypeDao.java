package com.fchen.ed.miner.dao;

import java.util.Set;

import com.fchen.ed.miner.model.Commodity;

public interface GenericStaticTypeDao<T> {
	public void addAll(Set<T> tSet);
	public void add(T t);
	public Set<Commodity> getAll();
}
