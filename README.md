# OOP with Math

This project aims to demonstrate the application of clean coding principles and object-oriented programming (OOP) practices through the implementation of mathematical expressions. The project progresses step by step, focusing on a hierarchy of classes representing mathematical expressions: Exponential, Multiplication, and Summation.

## Project Objective

The main goal of this project is to showcase the implementation of clean coding techniques and OOP principles in a practical manner. Each commit represents a step towards cleaner and more maintainable code. The project starts with simple mathematical expressions and gradually builds upon them to demonstrate the evolution of the codebase.

## Project Structure

The project follows a hierarchical structure where each class represents a specific mathematical concept:
- `Summation`: Represents Summation Operations, composed of a list of multiplication operations.
    - `Multiplication`: Represents Multiplication Operations, composed of a list of exponential expressions.
        - `Exponential`: Represents Exponential Expressions, consisting of a base and an exponent.
            - `base`: Represents Integer Numbers.
            - `exponent`: Represents Rational Numbers, consisting of a numerator and a denominator. This also allows us to express radical numbers.

The hierarchy starts from the most basic mathematical concept, the integer number, and progresses to more complex expressions such as exponentials, multiplications, and summations. Process priority is also an important factor here. Each class builds upon the previous one, showcasing the principles of object-oriented design.

## Project Plan

Each commit in the project represents a step towards cleaner code and better adherence to clean coding principles. Commits may include refactorings, improvements in code readability, adherence to SOLID principles, and the application of design patterns where applicable.

## Conclusion

By following this project, developers can gain insights into how clean coding principles and OOP practices can be applied in real-world projects. The progression from simple to complex mathematical expressions provides a clear and practical example of how to structure and design object-oriented systems.
