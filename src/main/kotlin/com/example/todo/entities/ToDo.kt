package com.example.todo.entities

import jakarta.persistence.*

@Table(name= "todo")
@Entity
class ToDo{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "title")
    var title: String? = null

    @Column(name = "completed")
    var completed: Boolean? = false

}

