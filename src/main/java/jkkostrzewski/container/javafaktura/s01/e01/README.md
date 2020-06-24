Functional interfaces
-
- Is an interface that contains only a single abstract method.
- Can contain default and static methods which have an implementation in 
addition to single unimplemented method
- Can be implemented by a lambda expression
- Examples: Function, BinaryOperator, UnaryOperator, Supplier, Consumer,
Predicate


Optional 
- 
- A safe container for objects
- Is generic
- Can't serialize
- "Our intention was to provide a limited mechanism for library 
method return types where there needed to be a clear way to represent 
no result, and using null for such was overwhelmingly likely to cause
errors" - Brian Goetz - creator of Optional


Stream
- 
- Lazy access to collection with options to transform, filter and much 
more
- Executes operations on every element and gives a result
- Does not modify entry data 
- BaseStream is an interface that all streams implement
- There are 4 stream classes : Stream for objects, IntStream, LongStream
and DoubleStream for primitive types
- Streams are lazy - they won't start executing logic if we don't use 
terminating operation like Stream.collect()

We can create streams with
- Stream.of
- Stream.empty
- Stream.builder
- Stream.generate
- Stream.iterate
- Collection.stream
