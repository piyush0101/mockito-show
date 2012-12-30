=============================
Easy Refactoring with Mockito
=============================

I aim to provide here a few insights into dealing with difficult to test code. Most of the time, when dealing with legacy 
code, you come across wildly tangled code. Dependencies are not well defined which results in tightly coupled, difficult 
to test code. Legacy systems which are running since a decade, have evolved in an strictly driven, its-ugly-but-it-works 
kind of environment are usually not very easy to fix overnight.

The best kind of system that is very easily testable is the one which follows good inversion of control/dependency 
injection patterns. Here are a couple of good articles about inversion of control and dependency injection from 
Paul Hammant and Martin Fowler.

