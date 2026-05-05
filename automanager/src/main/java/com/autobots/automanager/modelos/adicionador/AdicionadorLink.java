package com.autobots.automanager.modelos.adicionador;

import java.util.Collection;

public interface AdicionadorLink<T> {
	void adicionarLink(T objeto);

	default void adicionarLink(Collection<T> colecao) {
		colecao.forEach(this::adicionarLink);
	}
}