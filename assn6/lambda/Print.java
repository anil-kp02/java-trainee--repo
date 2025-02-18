package com.assn6.lambda;

import java.util.List;

@FunctionalInterface
public interface Print<T> {
	void print(List<T> list);

}
