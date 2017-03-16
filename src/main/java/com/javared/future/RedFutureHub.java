package com.javared.future;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mamot on 3/14/2017.
 */
public class RedFutureHub {

    private final List<ListenableFuture<?>> listenableFutures;

    protected RedFutureHub() {
        listenableFutures = new LinkedList<>();
    }

    public OpenRedFuture provideFuture() {
        OpenRedFuture future = RedFuture.future();
        listenableFutures.add(future.getListenableFuture());
        return future;
    }

    public <T> OpenRedFutureOf<T> provideFutureOf() {
        OpenRedFutureOf<T> future = RedFuture.futureOf();
        listenableFutures.add(future.getListenableFuture());
        return future;
    }

    public RedFutureHub adoptFuture(RedFuture future) {
        listenableFutures.add(future.getListenableFuture());
        return this;
    }

    public RedFutureHub adoptFutures(Collection<RedFuture> futures) {
        for (RedFuture future : futures) {
            listenableFutures.add(future.getListenableFuture());
        }
        return this;
    }

    public RedFutureHub adoptFutures(RedFuture... futures) {
        for (RedFuture future : futures) {
            listenableFutures.add(future.getListenableFuture());
        }
        return this;
    }

    public RedFutureHub adoptListenableFuture(ListenableFuture future) {
        listenableFutures.add(future);
        return this;
    }

    public RedFutureHub adoptListenableFutures(ListenableFuture<?>... futures) {
        Collections.addAll(listenableFutures, futures);
        return this;
    }

    public RedFutureHub adoptListenableFutures(Collection<ListenableFuture> futures) {
        for (ListenableFuture future : futures) {
            listenableFutures.add(future);
        }
        return this;
    }

    public RedFuture uniteOptimistically() {
        RedFuture validated = validate();
        if (validated != null) {
            return validated;
        }
        ListenableFuture<List<Object>> collection = Futures.allAsList(listenableFutures);
        return RedFuture.future().follow(collection);
    }

    public RedFuture unitePessimistically() {
        RedFuture validated = validate();
        if (validated != null) {
            return validated;
        }
        ListenableFuture<List<Object>> collection = Futures.successfulAsList(listenableFutures);
        return RedFuture.future().follow(collection);
    }

    public RedFuture uniteCautiously() {
        RedFuture validated = validate();
        if (validated != null) {
            return validated;
        }
        RedFuture optimistic = uniteOptimistically();
        RedFuture pessimistic = unitePessimistically();
        OpenRedFuture future = RedFuture.future();
        pessimistic.addSuccessCallback(() -> {
            future.follow(optimistic);
        });
        return future;
    }

    private RedFuture validate() {
        if (listenableFutures.size() == 0) {
            return RedFuture.resolved();
        }
        if (listenableFutures.size() == 1) {
            return RedFuture.future().follow(listenableFutures.get(0));
        }
        return null;
    }

}