// A functional interface that operates on an array
// and a value, and returns an int result.
public interface MyFunc<T> {
    int func(T[] vals, T v);
}
