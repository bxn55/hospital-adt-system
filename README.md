# Abstract Data Types (ADTs) Implementation

A comprehensive Java implementation of essential Abstract Data Types and their practical applications, including a hospital patient triage system.

## Overview

This project demonstrates the implementation and application of fundamental data structures in computer science:

- **Max Heap**: Priority-based patient triage system
- **Set (Hash-based)**: Student management and tracking
- **Binary Tree**: Organization hierarchy visualization

## Features

### Patient Triage System
- Register patients with unique IDs
- Maintain a priority queue based on severity and arrival time
- Process patients efficiently using a max heap
- View organization structure with tree traversals

### Data Structures Implemented
- `SimpleMaxHeap<E>`: Generic max heap with insert, extract, and peek operations
- `SimpleStudentSet`: Set operations for student collection management
- `SimpleOrganizationTree`: Binary tree for hierarchical structure traversal

## Project Structure

```
src/
  ├── SystemApp.java              # Main interactive application
  ├── Patient.java                # Patient model with severity tracking
  ├── PatientRegistry.java        # Patient registration management
  ├── SimpleMaxHeap.java          # Generic max heap implementation
  ├── SimpleStudentSet.java       # Student set implementation
  └── SimpleOrganizationTree.java # Binary tree for organization hierarchy

Heap/
  └── MaxHeapADT.java            # Max heap interface/contract

Set/
  └── StudentSetADT.java         # Set interface/contract

Tree/
  └── OrganizationTreeADT.java   # Tree interface/contract

lib/                             # External dependencies
bin/                             # Compiled output
```

## Getting Started

### Prerequisites
- Java 8 or higher
- VS Code with Extension Pack for Java (optional)

### Running the Application

Navigate to the project directory and compile:

```bash
javac -d bin src/*.java
```

Run the interactive system:

```bash
java -cp bin SystemApp
```

### Using the Menu

1. **Register Patient** - Add a new patient to the system
2. **Add to Triage** - Assign a registered patient to the priority queue
3. **Attend Next Patient** - Process the highest priority patient
4. **List Registered Patients** - View all registered patients
5. **Peek Triage** - View the next patient without removing
6. **Show Departments** - Display organization tree traversals

## Implementation Details

### Max Heap
- Generic implementation supporting any `Comparable<E>` type
- O(log n) insertion and extraction
- Maintains heap property through sift-up and sift-down operations

### Patient Triage Logic
- Primary sort: Severity level (1-10, higher = more urgent)
- Secondary sort: Arrival time (earlier patients prioritized if severity equal)
- Ensures fair and effective patient management

### Organization Tree
- Binary tree structure for department hierarchy
- Supports three traversal methods: preorder, inorder, postorder
- Useful for organizational visualization and reporting

## Example Usage

```java
SimpleMaxHeap<Patient> triage = new SimpleMaxHeap<>();
PatientRegistry registry = new PatientRegistry();

// Register a patient
registry.register("P001", "John Doe");

// Add to triage with severity level
Patient p = new Patient("P001", "John Doe", 8, 1);
triage.insert(p);

// Process next urgent patient
Patient next = triage.extractMax();
```

## Author Notes

This project serves as a practical demonstration of how abstract data types are used in real-world applications such as hospital management systems. Each data structure is implemented from first principles to illustrate key algorithmic concepts.

## License

This project is open source and available for educational purposes.
