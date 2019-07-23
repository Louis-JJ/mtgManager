package fr.mtg.gestion.services.utils;

import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Utility class for " <b>save if doesn't exist, else update</b> " strategy.
 * 
 * @author redSpoutnik
 *
 */
public final class SavingUtils {
	
	private SavingUtils() {
	}
	
	public static <T,U> T saveByParam(T t, Supplier<U> tSupp, Neo4jRepository<T, Long> repository, Function<U, T> rFind) {
		T exist = rFind.apply(tSupp.get());
		return exist == null ? repository.save(t) : exist;
	}
	
	public static <T> T saveById(T t, Supplier<Long> tSupp, Neo4jRepository<T, Long> repository) {
		Long id = tSupp.get();
		@SuppressWarnings("unchecked")
		T exist = id == null ? null : (T) repository.findById(id);
		return exist == null ? repository.save(t) : exist;
	}

}
