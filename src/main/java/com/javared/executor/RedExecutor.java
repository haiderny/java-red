package com.javared.executor;

import com.google.common.util.concurrent.ListenableFuture;
import com.javared.future.OpenRedFuture;
import com.javared.future.OpenRedFutureOf;
import com.javared.future.RedFuture;
import com.javared.future.RedFutureOf;

import java.util.concurrent.Future;

abstract public class RedExecutor<INPUT, OUTPUT> {

    private static final ReturnClassifier.ReturnClassifier0 RETURN_CLASSIFIER_0 = new ReturnClassifier.ReturnClassifier0();

    public RedFutureOf<OUTPUT> execute(INPUT input) {
        try {
            Result<OUTPUT> result = handle(input);
            return result._future;
        } catch (Throwable t) {
            return RedFuture.failedOf(t);
        }
    }

    abstract protected Result<OUTPUT> handle(INPUT input);

    protected Marker execute(Executables.Command0 command) {
        return RETURN_CLASSIFIER_0.execute(command);
    }

    protected <R> Runner.Runner0<R, R> produce(Class<R> tClass) {
        return RETURN_CLASSIFIER_0.produce(tClass);
    }

    protected <R> Runner.Runner0<Future<R>, R> produceFutureOf(Class<R> tClass) {
        return RETURN_CLASSIFIER_0.produceFutureOf(tClass);
    }

    protected <R> Runner.Runner0<ListenableFuture<R>, R> produceListenableFutureOf(Class<R> tClass) {
        return RETURN_CLASSIFIER_0.produceListenableFutureOf(tClass);
    }

    protected <R> Runner.Runner0<RedFutureOf<R>, R> produceRedFutureOf(Class<R> tClass) {
        return RETURN_CLASSIFIER_0.produceRedFutureOf(tClass);
    }

    protected FutureTransformer.FutureTransformer0 once(Marker... markers) {
        return new FutureTransformer.FutureTransformer0();
    }

    protected <T0> FutureTransformer.FutureTransformer1<T0> once(Result<T0> f0) {
        return new FutureTransformer.FutureTransformer1<>(f0);
    }

    protected <T0, T1> FutureTransformer.FutureTransformer2<T0, T1> once(Result<T0> f0, Result<T1> f1) {
        return new FutureTransformer.FutureTransformer2<>(f0, f1);
    }

    protected <T0, T1, T2> FutureTransformer.FutureTransformer3<T0, T1, T2> once(Result<T0> f0, Result<T1> f1, Result<T2> f2) {
        return new FutureTransformer.FutureTransformer3<>(f0, f1, f2);
    }

    protected <T0, T1, T2, T3> FutureTransformer.FutureTransformer4<T0, T1, T2, T3> once(Result<T0> f0, Result<T1> f1, Result<T2> f2, Result<T3> f3) {
        return new FutureTransformer.FutureTransformer4<>(f0, f1, f2, f3);
    }

    protected <T0, T1, T2, T3, T4> FutureTransformer.FutureTransformer5<T0, T1, T2, T3, T4> once(Result<T0> f0, Result<T1> f1, Result<T2> f2, Result<T3> f3, Result<T4> f4) {
        return new FutureTransformer.FutureTransformer5<>(f0, f1, f2, f3, f4);
    }

    protected <T0, T1, T2, T3, T4, T5> FutureTransformer.FutureTransformer6<T0, T1, T2, T3, T4, T5> once(Result<T0> f0, Result<T1> f1, Result<T2> f2, Result<T3> f3, Result<T4> f4, Result<T5> f5) {
        return new FutureTransformer.FutureTransformer6<>(f0, f1, f2, f3, f4, f5);
    }

    protected <T0, T1, T2, T3, T4, T5, T6> FutureTransformer.FutureTransformer7<T0, T1, T2, T3, T4, T5, T6> once(Result<T0> f0, Result<T1> f1, Result<T2> f2, Result<T3> f3, Result<T4> f4, Result<T5> f5, Result<T6> f6) {
        return new FutureTransformer.FutureTransformer7<>(f0, f1, f2, f3, f4, f5, f6);
    }

    protected <T0, T1, T2, T3, T4, T5, T6, T7> FutureTransformer.FutureTransformer8<T0, T1, T2, T3, T4, T5, T6, T7> once(Result<T0> f0, Result<T1> f1, Result<T2> f2, Result<T3> f3, Result<T4> f4, Result<T5> f5, Result<T6> f6, Result<T7> f7) {
        return new FutureTransformer.FutureTransformer8<>(f0, f1, f2, f3, f4, f5, f6, f7);
    }

    protected <T0, T1, T2, T3, T4, T5, T6, T7, T8> FutureTransformer.FutureTransformer9<T0, T1, T2, T3, T4, T5, T6, T7, T8> once(Result<T0> f0, Result<T1> f1, Result<T2> f2, Result<T3> f3, Result<T4> f4, Result<T5> f5, Result<T6> f6, Result<T7> f7, Result<T8> f8) {
        return new FutureTransformer.FutureTransformer9<>(f0, f1, f2, f3, f4, f5, f6, f7, f8);
    }

    protected <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> FutureTransformer.FutureTransformer10<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> once(Result<T0> f0, Result<T1> f1, Result<T2> f2, Result<T3> f3, Result<T4> f4, Result<T5> f5, Result<T6> f6, Result<T7> f7, Result<T8> f8, Result<T9> f9) {
        return new FutureTransformer.FutureTransformer10<>(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    private static <R> Converter<R, R> valueConverter() {
        return RedFuture::resolvedOf;
    }

    private static <R> Converter<Future<R>, R> futureConverter() {
        return RedFuture::convert;
    }

    private static <R> Converter<ListenableFuture<R>, R> listenableFutureConverter() {
        return RedFuture::convert;
    }

    private static <R> Converter<RedFutureOf<R>, R> redFutureConverter() {
        return RedExecutor::id;
    }

    private static <T> T id(T t) {
        return t;
    }

    protected static class Result<T> {

        private final OpenRedFutureOf<T> _future;

        private Result() {
            _future = RedFuture.futureOf();
        }

    }

    protected static class Marker {

        private final OpenRedFuture _future;

        private Marker() {
            _future = RedFuture.future();
        }

    }

    private interface Converter<WRAPPER, OF> {

        RedFutureOf<OF> convert(WRAPPER midType);

    }

    abstract private static class PrerequisitesHolder {

        private final RedFuture[] _prerequisites;

        private PrerequisitesHolder(RedFuture[] prerequisites) {
            _prerequisites = prerequisites;
        }

        RedFuture[] prerequisites() {
            return _prerequisites;
        }

        <T> T result(int index) {
            RedFuture future = _prerequisites[index];
            //noinspection unchecked
            return ((RedFutureOf<T>) future).tryGet();
        }

    }

    private abstract static class FutureTransformer<RETURN_CLASSIFIER> {

        private static final Throwable FLIPPED_EXCEPTION = new Exception("flipped future");

        private final RedFuture[] _oldPrerequisites;

        private final RedFuture[] _newPrerequisites;

        private FutureTransformer(RedFuture[] oldPrerequisites, Marker... markers) {
            _oldPrerequisites = oldPrerequisites;
            _newPrerequisites = new RedFuture[markers.length];
            for (int i = 0; i < markers.length; i++) {
                _newPrerequisites[i] = markers[i]._future;
            }
        }


        private FutureTransformer(Result... results) {
            _oldPrerequisites = new RedFuture[0];
            _newPrerequisites = new RedFuture[results.length];
            for (int i = 0; i < results.length; i++) {
                _newPrerequisites[i] = results[i]._future;
            }
        }

        public RETURN_CLASSIFIER succeed() {
            return createClassifier(_newPrerequisites);
        }

        public RETURN_CLASSIFIER fail() {
            return createClassifier(mapPrerequisites(_newPrerequisites, future -> {
                OpenRedFuture result = RedFuture.future();
                future.addSuccessCallback(() -> result.fail(FLIPPED_EXCEPTION));
                future.addFailureCallback(throwable -> result.resolve());
                return result;
            }));
        }

        public RETURN_CLASSIFIER finish() {
            return createClassifier(mapPrerequisites(_newPrerequisites, future -> {
                OpenRedFuture result = RedFuture.future();
                future.addFinallyCallback(result::resolve);
                return result;
            }));
        }

        private RETURN_CLASSIFIER createClassifier(RedFuture[] transformedPrerequisites) {
            RedFuture[] allPrerequisites = new RedFuture[transformedPrerequisites.length + _oldPrerequisites.length];
            System.arraycopy(_oldPrerequisites, 0, allPrerequisites, 0, _oldPrerequisites.length);
            System.arraycopy(transformedPrerequisites, 0, allPrerequisites, _oldPrerequisites.length, transformedPrerequisites.length);
            return classifier(allPrerequisites);
        }

        private static RedFuture[] mapPrerequisites(RedFuture[] prerequisites, Mapper mapper) {
            RedFuture[] result = new RedFuture[prerequisites.length];
            for (int i = 0; i < prerequisites.length; i++) {
                result[i] = mapper.map(prerequisites[i]);
            }
            return result;
        }

        private interface Mapper {

            RedFuture map(RedFuture future);

        }

        abstract protected RETURN_CLASSIFIER classifier(RedFuture[] prerequisites);

        public static class FutureTransformer0 extends FutureTransformer<ReturnClassifier.ReturnClassifier0> {

            @Override
            protected ReturnClassifier.ReturnClassifier0 classifier(RedFuture[] prerequisites) {
                return new ReturnClassifier.ReturnClassifier0();
            }

        }

        public static class FutureTransformer1<T0> extends FutureTransformer<ReturnClassifier.ReturnClassifier1<T0>> {

            private FutureTransformer1(Result<T0> r0) {
                super(r0);
            }

            private FutureTransformer1(RedFuture[] oldPrerequisites, Marker... markers) {
                super(oldPrerequisites, markers);
            }

            @Override
            protected ReturnClassifier.ReturnClassifier1<T0> classifier(RedFuture[] prerequisites) {
                return new ReturnClassifier.ReturnClassifier1<>(prerequisites);
            }

        }

        public static class FutureTransformer2<T0, T1> extends FutureTransformer<ReturnClassifier.ReturnClassifier2<T0, T1>> {

            private FutureTransformer2(Result<T0> r0, Result<T1> r1) {
                super(r0, r1);
            }

            private FutureTransformer2(RedFuture[] oldPrerequisites, Marker... markers) {
                super(oldPrerequisites, markers);
            }

            @Override
            protected ReturnClassifier.ReturnClassifier2<T0, T1> classifier(RedFuture[] prerequisites) {
                return new ReturnClassifier.ReturnClassifier2<>(prerequisites);
            }

        }

        public static class FutureTransformer3<T0, T1, T2> extends FutureTransformer<ReturnClassifier.ReturnClassifier3<T0, T1, T2>> {

            private FutureTransformer3(Result<T0> r0, Result<T1> r1, Result<T2> r2) {
                super(r0, r1, r2);
            }

            private FutureTransformer3(RedFuture[] oldPrerequisites, Marker... markers) {
                super(oldPrerequisites, markers);
            }

            @Override
            protected ReturnClassifier.ReturnClassifier3<T0, T1, T2> classifier(RedFuture[] prerequisites) {
                return new ReturnClassifier.ReturnClassifier3<>(prerequisites);
            }

        }

        public static class FutureTransformer4<T0, T1, T2, T3> extends FutureTransformer<ReturnClassifier.ReturnClassifier4<T0, T1, T2, T3>> {

            private FutureTransformer4(Result<T0> r0, Result<T1> r1, Result<T2> r2, Result<T3> r3) {
                super(r0, r1, r2, r3);
            }

            private FutureTransformer4(RedFuture[] oldPrerequisites, Marker... markers) {
                super(oldPrerequisites, markers);
            }

            @Override
            protected ReturnClassifier.ReturnClassifier4<T0, T1, T2, T3> classifier(RedFuture[] prerequisites) {
                return new ReturnClassifier.ReturnClassifier4<>(prerequisites);
            }

        }

        public static class FutureTransformer5<T0, T1, T2, T3, T4> extends FutureTransformer<ReturnClassifier.ReturnClassifier5<T0, T1, T2, T3, T4>> {

            private FutureTransformer5(Result<T0> r0, Result<T1> r1, Result<T2> r2, Result<T3> r3, Result<T4> r4) {
                super(r0, r1, r2, r3, r4);
            }

            private FutureTransformer5(RedFuture[] oldPrerequisites, Marker... markers) {
                super(oldPrerequisites, markers);
            }

            @Override
            protected ReturnClassifier.ReturnClassifier5<T0, T1, T2, T3, T4> classifier(RedFuture[] prerequisites) {
                return new ReturnClassifier.ReturnClassifier5<>(prerequisites);
            }

        }

        public static class FutureTransformer6<T0, T1, T2, T3, T4, T5> extends FutureTransformer<ReturnClassifier.ReturnClassifier6<T0, T1, T2, T3, T4, T5>> {

            private FutureTransformer6(Result<T0> r0, Result<T1> r1, Result<T2> r2, Result<T3> r3, Result<T4> r4, Result<T5> r5) {
                super(r0, r1, r2, r3, r4, r5);
            }

            private FutureTransformer6(RedFuture[] oldPrerequisites, Marker... markers) {
                super(oldPrerequisites, markers);
            }

            @Override
            protected ReturnClassifier.ReturnClassifier6<T0, T1, T2, T3, T4, T5> classifier(RedFuture[] prerequisites) {
                return new ReturnClassifier.ReturnClassifier6<>(prerequisites);
            }

        }

        public static class FutureTransformer7<T0, T1, T2, T3, T4, T5, T6> extends FutureTransformer<ReturnClassifier.ReturnClassifier7<T0, T1, T2, T3, T4, T5, T6>> {

            private FutureTransformer7(Result<T0> r0, Result<T1> r1, Result<T2> r2, Result<T3> r3, Result<T4> r4, Result<T5> r5, Result<T6> r6) {
                super(r0, r1, r2, r3, r4, r5, r6);
            }

            private FutureTransformer7(RedFuture[] oldPrerequisites, Marker... markers) {
                super(oldPrerequisites, markers);
            }

            @Override
            protected ReturnClassifier.ReturnClassifier7<T0, T1, T2, T3, T4, T5, T6> classifier(RedFuture[] prerequisites) {
                return new ReturnClassifier.ReturnClassifier7<>(prerequisites);
            }

        }

        public static class FutureTransformer8<T0, T1, T2, T3, T4, T5, T6, T7> extends FutureTransformer<ReturnClassifier.ReturnClassifier8<T0, T1, T2, T3, T4, T5, T6, T7>> {

            private FutureTransformer8(Result<T0> r0, Result<T1> r1, Result<T2> r2, Result<T3> r3, Result<T4> r4, Result<T5> r5, Result<T6> r6, Result<T7> r7) {
                super(r0, r1, r2, r3, r4, r5, r6, r7);
            }

            private FutureTransformer8(RedFuture[] oldPrerequisites, Marker... markers) {
                super(oldPrerequisites, markers);
            }

            @Override
            protected ReturnClassifier.ReturnClassifier8<T0, T1, T2, T3, T4, T5, T6, T7> classifier(RedFuture[] prerequisites) {
                return new ReturnClassifier.ReturnClassifier8<>(prerequisites);
            }

        }

        public static class FutureTransformer9<T0, T1, T2, T3, T4, T5, T6, T7, T8> extends FutureTransformer<ReturnClassifier.ReturnClassifier9<T0, T1, T2, T3, T4, T5, T6, T7, T8>> {

            private FutureTransformer9(Result<T0> r0, Result<T1> r1, Result<T2> r2, Result<T3> r3, Result<T4> r4, Result<T5> r5, Result<T6> r6, Result<T7> r7, Result<T8> r8) {
                super(r0, r1, r2, r3, r4, r5, r6, r7, r8);
            }

            private FutureTransformer9(RedFuture[] oldPrerequisites, Marker... markers) {
                super(oldPrerequisites, markers);
            }

            @Override
            protected ReturnClassifier.ReturnClassifier9<T0, T1, T2, T3, T4, T5, T6, T7, T8> classifier(RedFuture[] prerequisites) {
                return new ReturnClassifier.ReturnClassifier9<>(prerequisites);
            }

        }

        public static class FutureTransformer10<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FutureTransformer<ReturnClassifier.ReturnClassifier10<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9>> {

            private FutureTransformer10(Result<T0> r0, Result<T1> r1, Result<T2> r2, Result<T3> r3, Result<T4> r4, Result<T5> r5, Result<T6> r6, Result<T7> r7, Result<T8> r8, Result<T9> r9) {
                super(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
            }

            private FutureTransformer10(RedFuture[] oldPrerequisites, Marker... markers) {
                super(oldPrerequisites, markers);
            }

            @Override
            protected ReturnClassifier.ReturnClassifier10<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> classifier(RedFuture[] prerequisites) {
                return new ReturnClassifier.ReturnClassifier10<>(prerequisites);
            }

        }

    }

    abstract public static class ReturnClassifier<COMMAND, TRANSFORMER> extends PrerequisitesHolder {

        private ReturnClassifier(RedFuture[] prerequisites) {
            super(prerequisites);
        }

        public Marker execute(COMMAND c) {
            Marker marker = new Marker();
            RedFuture
                    .hub()
                    .adoptFutures(prerequisites())
                    .uniteOptimistically()
                    .addFailureCallback(marker._future::fail)
                    .addSuccessCallback(() -> {
                        try {
                            call(c, marker._future);
                        } catch (Throwable t) {
                            marker._future.fail(t);
                        }
                    });
            return marker;
        }

        abstract protected void call(COMMAND c, OpenRedFuture future);

        abstract protected TRANSFORMER andMarkers(RedFuture[] oldPrerequisites, Marker... markers);

        @SuppressWarnings("unused")
        public static class ReturnClassifier0 extends ReturnClassifier<Executables.Command0, Object> {

            private ReturnClassifier0() {
                super(new RedFuture[0]);
            }

            @Override
            protected void call(Executables.Command0 c, OpenRedFuture future) {
                c.call(future);
            }

            @Override
            protected Object andMarkers(RedFuture[] oldPrerequisites, Marker... markers) {
                return null;
            }

            public <R> Runner.Runner0<R, R> produce(Class<R> tClass) {
                return new Runner.Runner0<>(valueConverter());
            }

            public <R> Runner.Runner0<Future<R>, R> produceFutureOf(Class<R> tClass) {
                return new Runner.Runner0<>(futureConverter());
            }

            public <R> Runner.Runner0<ListenableFuture<R>, R> produceListenableFutureOf(Class<R> tClass) {
                return new Runner.Runner0<>(listenableFutureConverter());
            }

            public <R> Runner.Runner0<RedFutureOf<R>, R> produceRedFutureOf(Class<R> tClass) {
                return new Runner.Runner0<>(redFutureConverter());
            }

        }

        @SuppressWarnings("unused")
        public static class ReturnClassifier1<T0> extends ReturnClassifier<Executables.Command1<T0>, FutureTransformer.FutureTransformer1<T0>> {

            private ReturnClassifier1(RedFuture[] prerequisites) {
                super(prerequisites);
            }

            @Override
            protected void call(Executables.Command1<T0> c, OpenRedFuture future) {
                c.call(future, result(0));
            }

            @Override
            protected FutureTransformer.FutureTransformer1<T0> andMarkers(RedFuture[] oldPrerequisites, Marker... markers) {
                return new FutureTransformer.FutureTransformer1<>(oldPrerequisites, markers);
            }

            public <R> Runner.Runner1<R, R, T0> produce(Class<R> tClass) {
                return new Runner.Runner1<>(prerequisites(), valueConverter());
            }

            public <R> Runner.Runner1<Future<R>, R, T0> produceFutureOf(Class<R> tClass) {
                return new Runner.Runner1<>(prerequisites(), futureConverter());
            }

            public <R> Runner.Runner1<ListenableFuture<R>, R, T0> produceListenableFutureOf(Class<R> tClass) {
                return new Runner.Runner1<>(prerequisites(), listenableFutureConverter());
            }

            public <R> Runner.Runner1<RedFutureOf<R>, R, T0> produceRedFutureOf(Class<R> tClass) {
                return new Runner.Runner1<>(prerequisites(), redFutureConverter());
            }

        }

        @SuppressWarnings("unused")
        public static class ReturnClassifier2<T0, T1> extends ReturnClassifier<Executables.Command2<T0, T1>, FutureTransformer.FutureTransformer2<T0, T1>> {

            private ReturnClassifier2(RedFuture[] prerequisites) {
                super(prerequisites);
            }

            @Override
            protected void call(Executables.Command2<T0, T1> c, OpenRedFuture future) {
                c.call(future, result(0), result(1));
            }

            @Override
            protected FutureTransformer.FutureTransformer2<T0, T1> andMarkers(RedFuture[] oldPrerequisites, Marker... markers) {
                return new FutureTransformer.FutureTransformer2<>(oldPrerequisites, markers);
            }

            public <R> Runner.Runner2<R, R, T0, T1> produce(Class<R> tClass) {
                return new Runner.Runner2<>(prerequisites(), valueConverter());
            }

            public <R> Runner.Runner2<Future<R>, R, T0, T1> produceFutureOf(Class<R> tClass) {
                return new Runner.Runner2<>(prerequisites(), futureConverter());
            }

            public <R> Runner.Runner2<ListenableFuture<R>, R, T0, T1> produceListenableFutureOf(Class<R> tClass) {
                return new Runner.Runner2<>(prerequisites(), listenableFutureConverter());
            }

            public <R> Runner.Runner2<RedFutureOf<R>, R, T0, T1> produceRedFutureOf(Class<R> tClass) {
                return new Runner.Runner2<>(prerequisites(), redFutureConverter());
            }

        }

        @SuppressWarnings("unused")
        public static class ReturnClassifier3<T0, T1, T2> extends ReturnClassifier<Executables.Command3<T0, T1, T2>, FutureTransformer.FutureTransformer3<T0, T1, T2>> {

            private ReturnClassifier3(RedFuture[] prerequisites) {
                super(prerequisites);
            }

            @Override
            protected void call(Executables.Command3<T0, T1, T2> c, OpenRedFuture future) {
                c.call(future, result(0), result(1), result(2));
            }

            @Override
            protected FutureTransformer.FutureTransformer3<T0, T1, T2> andMarkers(RedFuture[] oldPrerequisites, Marker... markers) {
                return new FutureTransformer.FutureTransformer3<>(oldPrerequisites, markers);
            }

            public <R> Runner.Runner3<R, R, T0, T1, T2> produce(Class<R> tClass) {
                return new Runner.Runner3<>(prerequisites(), valueConverter());
            }

            public <R> Runner.Runner3<Future<R>, R, T0, T1, T2> produceFutureOf(Class<R> tClass) {
                return new Runner.Runner3<>(prerequisites(), futureConverter());
            }

            public <R> Runner.Runner3<ListenableFuture<R>, R, T0, T1, T2> produceListenableFutureOf(Class<R> tClass) {
                return new Runner.Runner3<>(prerequisites(), listenableFutureConverter());
            }

            public <R> Runner.Runner3<RedFutureOf<R>, R, T0, T1, T2> produceRedFutureOf(Class<R> tClass) {
                return new Runner.Runner3<>(prerequisites(), redFutureConverter());
            }

        }

        @SuppressWarnings("unused")
        public static class ReturnClassifier4<T0, T1, T2, T3> extends ReturnClassifier<Executables.Command4<T0, T1, T2, T3>, FutureTransformer.FutureTransformer4<T0, T1, T2, T3>> {

            private ReturnClassifier4(RedFuture[] prerequisites) {
                super(prerequisites);
            }

            @Override
            protected void call(Executables.Command4<T0, T1, T2, T3> c, OpenRedFuture future) {
                c.call(future, result(0), result(1), result(2), result(3));
            }

            @Override
            protected FutureTransformer.FutureTransformer4<T0, T1, T2, T3> andMarkers(RedFuture[] oldPrerequisites, Marker... markers) {
                return new FutureTransformer.FutureTransformer4<>(oldPrerequisites, markers);
            }

            public <R> Runner.Runner4<R, R, T0, T1, T2, T3> produce(Class<R> tClass) {
                return new Runner.Runner4<>(prerequisites(), valueConverter());
            }

            public <R> Runner.Runner4<Future<R>, R, T0, T1, T2, T3> produceFutureOf(Class<R> tClass) {
                return new Runner.Runner4<>(prerequisites(), futureConverter());
            }

            public <R> Runner.Runner4<ListenableFuture<R>, R, T0, T1, T2, T3> produceListenableFutureOf(Class<R> tClass) {
                return new Runner.Runner4<>(prerequisites(), listenableFutureConverter());
            }

            public <R> Runner.Runner4<RedFutureOf<R>, R, T0, T1, T2, T3> produceRedFutureOf(Class<R> tClass) {
                return new Runner.Runner4<>(prerequisites(), redFutureConverter());
            }

        }

        @SuppressWarnings("unused")
        public static class ReturnClassifier5<T0, T1, T2, T3, T4> extends ReturnClassifier<Executables.Command5<T0, T1, T2, T3, T4>, FutureTransformer.FutureTransformer5<T0, T1, T2, T3, T4>> {

            private ReturnClassifier5(RedFuture[] prerequisites) {
                super(prerequisites);
            }

            @Override
            protected void call(Executables.Command5<T0, T1, T2, T3, T4> c, OpenRedFuture future) {
                c.call(future, result(0), result(1), result(2), result(3), result(4));
            }

            @Override
            protected FutureTransformer.FutureTransformer5<T0, T1, T2, T3, T4> andMarkers(RedFuture[] oldPrerequisites, Marker... markers) {
                return new FutureTransformer.FutureTransformer5<>(oldPrerequisites, markers);
            }

            public <R> Runner.Runner5<R, R, T0, T1, T2, T3, T4> produce(Class<R> tClass) {
                return new Runner.Runner5<>(prerequisites(), valueConverter());
            }

            public <R> Runner.Runner5<Future<R>, R, T0, T1, T2, T3, T4> produceFutureOf(Class<R> tClass) {
                return new Runner.Runner5<>(prerequisites(), futureConverter());
            }

            public <R> Runner.Runner5<ListenableFuture<R>, R, T0, T1, T2, T3, T4> produceListenableFutureOf(Class<R> tClass) {
                return new Runner.Runner5<>(prerequisites(), listenableFutureConverter());
            }

            public <R> Runner.Runner5<RedFutureOf<R>, R, T0, T1, T2, T3, T4> produceRedFutureOf(Class<R> tClass) {
                return new Runner.Runner5<>(prerequisites(), redFutureConverter());
            }

        }

        @SuppressWarnings("unused")
        public static class ReturnClassifier6<T0, T1, T2, T3, T4, T5> extends ReturnClassifier<Executables.Command6<T0, T1, T2, T3, T4, T5>, FutureTransformer.FutureTransformer6<T0, T1, T2, T3, T4, T5>> {

            private ReturnClassifier6(RedFuture[] prerequisites) {
                super(prerequisites);
            }

            @Override
            protected void call(Executables.Command6<T0, T1, T2, T3, T4, T5> c, OpenRedFuture future) {
                c.call(future, result(0), result(1), result(2), result(3), result(4), result(5));
            }

            @Override
            protected FutureTransformer.FutureTransformer6<T0, T1, T2, T3, T4, T5> andMarkers(RedFuture[] oldPrerequisites, Marker... markers) {
                return new FutureTransformer.FutureTransformer6<>(oldPrerequisites, markers);
            }

            public <R> Runner.Runner6<R, R, T0, T1, T2, T3, T4, T5> produce(Class<R> tClass) {
                return new Runner.Runner6<>(prerequisites(), valueConverter());
            }

            public <R> Runner.Runner6<Future<R>, R, T0, T1, T2, T3, T4, T5> produceFutureOf(Class<R> tClass) {
                return new Runner.Runner6<>(prerequisites(), futureConverter());
            }

            public <R> Runner.Runner6<ListenableFuture<R>, R, T0, T1, T2, T3, T4, T5> produceListenableFutureOf(Class<R> tClass) {
                return new Runner.Runner6<>(prerequisites(), listenableFutureConverter());
            }

            public <R> Runner.Runner6<RedFutureOf<R>, R, T0, T1, T2, T3, T4, T5> produceRedFutureOf(Class<R> tClass) {
                return new Runner.Runner6<>(prerequisites(), redFutureConverter());
            }

        }

        @SuppressWarnings("unused")
        public static class ReturnClassifier7<T0, T1, T2, T3, T4, T5, T6> extends ReturnClassifier<Executables.Command7<T0, T1, T2, T3, T4, T5, T6>, FutureTransformer.FutureTransformer7<T0, T1, T2, T3, T4, T5, T6>> {

            private ReturnClassifier7(RedFuture[] prerequisites) {
                super(prerequisites);
            }

            @Override
            protected void call(Executables.Command7<T0, T1, T2, T3, T4, T5, T6> c, OpenRedFuture future) {
                c.call(future, result(0), result(1), result(2), result(3), result(4), result(5), result(6));
            }

            @Override
            protected FutureTransformer.FutureTransformer7<T0, T1, T2, T3, T4, T5, T6> andMarkers(RedFuture[] oldPrerequisites, Marker... markers) {
                return new FutureTransformer.FutureTransformer7<>(oldPrerequisites, markers);
            }

            public <R> Runner.Runner7<R, R, T0, T1, T2, T3, T4, T5, T6> produce(Class<R> tClass) {
                return new Runner.Runner7<>(prerequisites(), valueConverter());
            }

            public <R> Runner.Runner7<Future<R>, R, T0, T1, T2, T3, T4, T5, T6> produceFutureOf(Class<R> tClass) {
                return new Runner.Runner7<>(prerequisites(), futureConverter());
            }

            public <R> Runner.Runner7<ListenableFuture<R>, R, T0, T1, T2, T3, T4, T5, T6> produceListenableFutureOf(Class<R> tClass) {
                return new Runner.Runner7<>(prerequisites(), listenableFutureConverter());
            }

            public <R> Runner.Runner7<RedFutureOf<R>, R, T0, T1, T2, T3, T4, T5, T6> produceRedFutureOf(Class<R> tClass) {
                return new Runner.Runner7<>(prerequisites(), redFutureConverter());
            }

        }

        @SuppressWarnings("unused")
        public static class ReturnClassifier8<T0, T1, T2, T3, T4, T5, T6, T7> extends ReturnClassifier<Executables.Command8<T0, T1, T2, T3, T4, T5, T6, T7>, FutureTransformer.FutureTransformer8<T0, T1, T2, T3, T4, T5, T6, T7>> {

            private ReturnClassifier8(RedFuture[] prerequisites) {
                super(prerequisites);
            }

            @Override
            protected void call(Executables.Command8<T0, T1, T2, T3, T4, T5, T6, T7> c, OpenRedFuture future) {
                c.call(future, result(0), result(1), result(2), result(3), result(4), result(5), result(6), result(7));
            }

            @Override
            protected FutureTransformer.FutureTransformer8<T0, T1, T2, T3, T4, T5, T6, T7> andMarkers(RedFuture[] oldPrerequisites, Marker... markers) {
                return new FutureTransformer.FutureTransformer8<>(oldPrerequisites, markers);
            }

            public <R> Runner.Runner8<R, R, T0, T1, T2, T3, T4, T5, T6, T7> produce(Class<R> tClass) {
                return new Runner.Runner8<>(prerequisites(), valueConverter());
            }

            public <R> Runner.Runner8<Future<R>, R, T0, T1, T2, T3, T4, T5, T6, T7> produceFutureOf(Class<R> tClass) {
                return new Runner.Runner8<>(prerequisites(), futureConverter());
            }

            public <R> Runner.Runner8<ListenableFuture<R>, R, T0, T1, T2, T3, T4, T5, T6, T7> produceListenableFutureOf(Class<R> tClass) {
                return new Runner.Runner8<>(prerequisites(), listenableFutureConverter());
            }

            public <R> Runner.Runner8<RedFutureOf<R>, R, T0, T1, T2, T3, T4, T5, T6, T7> produceRedFutureOf(Class<R> tClass) {
                return new Runner.Runner8<>(prerequisites(), redFutureConverter());
            }

        }

        @SuppressWarnings("unused")
        public static class ReturnClassifier9<T0, T1, T2, T3, T4, T5, T6, T7, T8> extends ReturnClassifier<Executables.Command9<T0, T1, T2, T3, T4, T5, T6, T7, T8>, FutureTransformer.FutureTransformer9<T0, T1, T2, T3, T4, T5, T6, T7, T8>> {

            private ReturnClassifier9(RedFuture[] prerequisites) {
                super(prerequisites);
            }

            @Override
            protected void call(Executables.Command9<T0, T1, T2, T3, T4, T5, T6, T7, T8> c, OpenRedFuture future) {
                c.call(future, result(0), result(1), result(2), result(3), result(4), result(5), result(6), result(7), result(8));
            }

            @Override
            protected FutureTransformer.FutureTransformer9<T0, T1, T2, T3, T4, T5, T6, T7, T8> andMarkers(RedFuture[] oldPrerequisites, Marker... markers) {
                return new FutureTransformer.FutureTransformer9<>(oldPrerequisites, markers);
            }

            public <R> Runner.Runner9<R, R, T0, T1, T2, T3, T4, T5, T6, T7, T8> produce(Class<R> tClass) {
                return new Runner.Runner9<>(prerequisites(), valueConverter());
            }

            public <R> Runner.Runner9<Future<R>, R, T0, T1, T2, T3, T4, T5, T6, T7, T8> produceFutureOf(Class<R> tClass) {
                return new Runner.Runner9<>(prerequisites(), futureConverter());
            }

            public <R> Runner.Runner9<ListenableFuture<R>, R, T0, T1, T2, T3, T4, T5, T6, T7, T8> produceListenableFutureOf(Class<R> tClass) {
                return new Runner.Runner9<>(prerequisites(), listenableFutureConverter());
            }

            public <R> Runner.Runner9<RedFutureOf<R>, R, T0, T1, T2, T3, T4, T5, T6, T7, T8> produceRedFutureOf(Class<R> tClass) {
                return new Runner.Runner9<>(prerequisites(), redFutureConverter());
            }

        }

        @SuppressWarnings("unused")
        public static class ReturnClassifier10<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends ReturnClassifier<Executables.Command10<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9>, FutureTransformer.FutureTransformer10<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9>> {

            private ReturnClassifier10(RedFuture[] prerequisites) {
                super(prerequisites);
            }

            @Override
            protected void call(Executables.Command10<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> c, OpenRedFuture future) {
                c.call(future, result(0), result(1), result(2), result(3), result(4), result(5), result(6), result(7), result(8), result(9));
            }

            @Override
            protected FutureTransformer.FutureTransformer10<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> andMarkers(RedFuture[] oldPrerequisites, Marker... markers) {
                return new FutureTransformer.FutureTransformer10<>(oldPrerequisites, markers);
            }

            public <R> Runner.Runner10<R, R, T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> produce(Class<R> tClass) {
                return new Runner.Runner10<>(prerequisites(), valueConverter());
            }

            public <R> Runner.Runner10<Future<R>, R, T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> produceFutureOf(Class<R> tClass) {
                return new Runner.Runner10<>(prerequisites(), futureConverter());
            }

            public <R> Runner.Runner10<ListenableFuture<R>, R, T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> produceListenableFutureOf(Class<R> tClass) {
                return new Runner.Runner10<>(prerequisites(), listenableFutureConverter());
            }

            public <R> Runner.Runner10<RedFutureOf<R>, R, T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> produceRedFutureOf(Class<R> tClass) {
                return new Runner.Runner10<>(prerequisites(), redFutureConverter());
            }

        }

    }

    abstract private static class Runner<FUNCTION, WRAPPER, R> extends PrerequisitesHolder {

        private final Converter<WRAPPER, R> _converter;

        private Runner(RedFuture[] prerequisites, Converter<WRAPPER, R> converter) {
            super(prerequisites);
            _converter = converter;
        }

        public Result<R> byExecuting(FUNCTION f) {
            Result<R> result = new Result<>();
            RedFuture
                    .hub()
                    .adoptFutures(prerequisites())
                    .uniteOptimistically()
                    .addFailureCallback(result._future::fail)
                    .addSuccessCallback(() -> {
                        try {
                            WRAPPER wrapper = call(f);
                            RedFutureOf<R> toFollow = _converter.convert(wrapper);
                            result._future.follow(toFollow);
                        } catch (Throwable t) {
                            result._future.fail(t);
                        }
                    });
            return result;
        }

        abstract protected WRAPPER call(FUNCTION f);

        public static class Runner0<WRAPPER, R> extends Runner<Executables.Function0<WRAPPER>, WRAPPER, R> {

            private Runner0(Converter<WRAPPER, R> converter) {
                super(new RedFuture[] {}, converter);
            }

            @Override
            protected WRAPPER call(Executables.Function0<WRAPPER> f) {
                return f.call();
            }

        }

        public static class Runner1<WRAPPER, R, T0> extends Runner<Executables.Function1<WRAPPER, T0>, WRAPPER, R> {

            private Runner1(RedFuture[] prerequisites, Converter<WRAPPER, R> converter) {
                super(prerequisites, converter);
            }

            @Override
            protected WRAPPER call(Executables.Function1<WRAPPER, T0> f) {
                return f.call(result(0));
            }

        }

        public static class Runner2<WRAPPER, R, T0, T1> extends Runner<Executables.Function2<WRAPPER, T0, T1>, WRAPPER, R> {

            private Runner2(RedFuture[] prerequisites, Converter<WRAPPER, R> converter) {
                super(prerequisites, converter);
            }

            @Override
            protected WRAPPER call(Executables.Function2<WRAPPER, T0, T1> f) {
                return f.call(result(0), result(1));
            }

        }

        public static class Runner3<WRAPPER, R, T0, T1, T2> extends Runner<Executables.Function3<WRAPPER, T0, T1, T2>, WRAPPER, R> {

            private Runner3(RedFuture[] prerequisites, Converter<WRAPPER, R> converter) {
                super(prerequisites, converter);
            }

            @Override
            protected WRAPPER call(Executables.Function3<WRAPPER, T0, T1, T2> f) {
                return f.call(result(0), result(1), result(2));
            }

        }

        public static class Runner4<WRAPPER, R, T0, T1, T2, T3> extends Runner<Executables.Function4<WRAPPER, T0, T1, T2, T3>, WRAPPER, R> {

            private Runner4(RedFuture[] prerequisites, Converter<WRAPPER, R> converter) {
                super(prerequisites, converter);
            }

            @Override
            protected WRAPPER call(Executables.Function4<WRAPPER, T0, T1, T2, T3> f) {
                return f.call(result(0), result(1), result(2), result(3));
            }

        }

        public static class Runner5<WRAPPER, R, T0, T1, T2, T3, T4> extends Runner<Executables.Function5<WRAPPER, T0, T1, T2, T3, T4>, WRAPPER, R> {

            private Runner5(RedFuture[] prerequisites, Converter<WRAPPER, R> converter) {
                super(prerequisites, converter);
            }

            @Override
            protected WRAPPER call(Executables.Function5<WRAPPER, T0, T1, T2, T3, T4> f) {
                return f.call(result(0), result(1), result(2), result(3), result(4));
            }

        }

        public static class Runner6<WRAPPER, R, T0, T1, T2, T3, T4, T5> extends Runner<Executables.Function6<WRAPPER, T0, T1, T2, T3, T4, T5>, WRAPPER, R> {

            private Runner6(RedFuture[] prerequisites, Converter<WRAPPER, R> converter) {
                super(prerequisites, converter);
            }

            @Override
            protected WRAPPER call(Executables.Function6<WRAPPER, T0, T1, T2, T3, T4, T5> f) {
                return f.call(result(0), result(1), result(2), result(3), result(4), result(5));
            }

        }

        public static class Runner7<WRAPPER, R, T0, T1, T2, T3, T4, T5, T6> extends Runner<Executables.Function7<WRAPPER, T0, T1, T2, T3, T4, T5, T6>, WRAPPER, R> {

            private Runner7(RedFuture[] prerequisites, Converter<WRAPPER, R> converter) {
                super(prerequisites, converter);
            }

            @Override
            protected WRAPPER call(Executables.Function7<WRAPPER, T0, T1, T2, T3, T4, T5, T6> f) {
                return f.call(result(0), result(1), result(2), result(3), result(4), result(5), result(6));
            }

        }

        public static class Runner8<WRAPPER, R, T0, T1, T2, T3, T4, T5, T6, T7> extends Runner<Executables.Function8<WRAPPER, T0, T1, T2, T3, T4, T5, T6, T7>, WRAPPER, R> {

            private Runner8(RedFuture[] prerequisites, Converter<WRAPPER, R> converter) {
                super(prerequisites, converter);
            }

            @Override
            protected WRAPPER call(Executables.Function8<WRAPPER, T0, T1, T2, T3, T4, T5, T6, T7> f) {
                return f.call(result(0), result(1), result(2), result(3), result(4), result(5), result(6), result(7));
            }

        }

        public static class Runner9<WRAPPER, R, T0, T1, T2, T3, T4, T5, T6, T7, T8> extends Runner<Executables.Function9<WRAPPER, T0, T1, T2, T3, T4, T5, T6, T7, T8>, WRAPPER, R> {

            private Runner9(RedFuture[] prerequisites, Converter<WRAPPER, R> converter) {
                super(prerequisites, converter);
            }

            @Override
            protected WRAPPER call(Executables.Function9<WRAPPER, T0, T1, T2, T3, T4, T5, T6, T7, T8> f) {
                return f.call(result(0), result(1), result(2), result(3), result(4), result(5), result(6), result(7), result(8));
            }

        }

        public static class Runner10<WRAPPER, R, T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends Runner<Executables.Function10<WRAPPER, T0, T1, T2, T3, T4, T5, T6, T7, T8, T9>, WRAPPER, R> {

            private Runner10(RedFuture[] prerequisites, Converter<WRAPPER, R> converter) {
                super(prerequisites, converter);
            }

            @Override
            protected WRAPPER call(Executables.Function10<WRAPPER, T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> f) {
                return f.call(result(0), result(1), result(2), result(3), result(4), result(5), result(6), result(7), result(8), result(9));
            }

        }

    }

    private static class Executables {

        public interface Function0<WRAPPER> {

            WRAPPER call();

        }

        public interface Function1<WRAPPER, T0> {

            WRAPPER call(T0 f0);

        }

        public interface Function2<WRAPPER, T0, T1> {

            WRAPPER call(T0 f0, T1 f1);

        }

        public interface Function3<WRAPPER, T0, T1, T2> {

            WRAPPER call(T0 f0, T1 f1, T2 f2);

        }

        public interface Function4<WRAPPER, T0, T1, T2, T3> {

            WRAPPER call(T0 f0, T1 f1, T2 f2, T3 f3);

        }

        public interface Function5<WRAPPER, T0, T1, T2, T3, T4> {

            WRAPPER call(T0 f0, T1 f1, T2 f2, T3 f3, T4 f4);

        }

        public interface Function6<WRAPPER, T0, T1, T2, T3, T4, T5> {

            WRAPPER call(T0 f0, T1 f1, T2 f2, T3 f3, T4 f4, T5 f5);

        }

        public interface Function7<WRAPPER, T0, T1, T2, T3, T4, T5, T6> {

            WRAPPER call(T0 f0, T1 f1, T2 f2, T3 f3, T4 f4, T5 f5, T6 f6);

        }

        public interface Function8<WRAPPER, T0, T1, T2, T3, T4, T5, T6, T7> {

            WRAPPER call(T0 f0, T1 f1, T2 f2, T3 f3, T4 f4, T5 f5, T6 f6, T7 f7);

        }

        public interface Function9<WRAPPER, T0, T1, T2, T3, T4, T5, T6, T7, T8> {

            WRAPPER call(T0 f0, T1 f1, T2 f2, T3 f3, T4 f4, T5 f5, T6 f6, T7 f7, T8 f8);

        }

        public interface Function10<WRAPPER, T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> {

            WRAPPER call(T0 f0, T1 f1, T2 f2, T3 f3, T4 f4, T5 f5, T6 f6, T7 f7, T8 f8, T9 f9);

        }

        public interface Command0 {

            void call(OpenRedFuture result);

        }

        public interface Command1<T0> {

            void call(OpenRedFuture result, T0 f0);

        }

        public interface Command2<T0, T1> {

            void call(OpenRedFuture result, T0 f0, T1 f1);

        }

        public interface Command3<T0, T1, T2> {

            void call(OpenRedFuture result, T0 f0, T1 f1, T2 f2);

        }

        public interface Command4<T0, T1, T2, T3> {

            void call(OpenRedFuture result, T0 f0, T1 f1, T2 f2, T3 f3);

        }

        public interface Command5<T0, T1, T2, T3, T4> {

            void call(OpenRedFuture result, T0 f0, T1 f1, T2 f2, T3 f3, T4 f4);

        }

        public interface Command6<T0, T1, T2, T3, T4, T5> {

            void call(OpenRedFuture result, T0 f0, T1 f1, T2 f2, T3 f3, T4 f4, T5 f5);

        }

        public interface Command7<T0, T1, T2, T3, T4, T5, T6> {

            void call(OpenRedFuture result, T0 f0, T1 f1, T2 f2, T3 f3, T4 f4, T5 f5, T6 f6);

        }

        public interface Command8<T0, T1, T2, T3, T4, T5, T6, T7> {

            void call(OpenRedFuture result, T0 f0, T1 f1, T2 f2, T3 f3, T4 f4, T5 f5, T6 f6, T7 f7);

        }

        public interface Command9<T0, T1, T2, T3, T4, T5, T6, T7, T8> {

            void call(OpenRedFuture result, T0 f0, T1 f1, T2 f2, T3 f3, T4 f4, T5 f5, T6 f6, T7 f7, T8 f8);

        }

        public interface Command10<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> {

            void call(OpenRedFuture result, T0 f0, T1 f1, T2 f2, T3 f3, T4 f4, T5 f5, T6 f6, T7 f7, T8 f8, T9 f9);

        }

    }

}
