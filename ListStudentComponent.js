import React, { useEffect, useState } from 'react'
import {Link} from 'react-router-dom'
import StudentService from '../services/StudentService'

function ListStudentComponent() {

    const [students, setStudents] = useState([])

    useEffect(() => {
        getAllStudents();
   
    },[])

    const getAllStudents = () =>{
        StudentService.getAllStudents().then((Response) => {
            setStudents(Response.data)
            console.log(Response.data)
        }).catch(error =>{
            console.log(error);
        })

    }

    const deleteStudent = (studentId) =>{
        StudentService.deleteStudent(studentId).then((Response) =>{
            getAllStudents();
        }).catch(error =>{
            console.log(error);
        })
     

    }

  return (
    <div className= "container">
        <h2 className='text-center'>Students List</h2>
        <div>
        <Link to="/add-student" className="btn btn-primary mb-2">Add Student</Link>
        </div>
        <table className='table table-bordered table-striped  '>
            <thead>
                <tr>
                <th>Student id </th>
                <th>Student Name</th>
                <th>Student Grade</th>
                <th>Student Address</th>
                <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    students.map(
                        student =>
                        <tr key = {student.sid}>
                            <td>{student.sid}</td>
                            <td>{student.sName}</td>
                            <td>{student.sGrade}</td>
                            <td>{student.sAddress}</td>
                            <td>
                                <Link to={`/edit-student/${student.sid}`} className='btn btn-info'>update</Link>
                                <button className='btn btn-danger' onClick={()=> deleteStudent(student.sid)} style={{marginLeft:"10px"}}>Delete</button>
                            </td>
                        </tr>
                    )
                }
               
            </tbody>
        </table>

    </div>
  )
}

export default ListStudentComponent