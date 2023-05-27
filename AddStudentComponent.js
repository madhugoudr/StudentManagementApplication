import React , {useState,useEffect} from 'react'
import {Link} from 'react-router-dom'
import { useNavigate , useParams} from 'react-router-dom'
import StudentService from '../services/StudentService'

function AddStudentComponent() {

 
  const [sName, setsName] = useState('')
  const [sGrade, setsGrade] = useState('')
  const [sAddress, setsAddress] = useState('')

  const navigate = useNavigate();
  const {sid} = useParams();



  const saveOrUpdateStudent = (e) =>{
    e.preventDefault();

    const student = { sName, sGrade, sAddress}

    if(sid){
      StudentService.updateStudent(sid, student).then((Response) =>{
        navigate.push('/students');
      }).catch(error =>{
        console.log(error);
      })
    }

    else{
      StudentService.createStudent(student).then((Response) =>{
        console.log(Response.data);
        navigate.push('/students')
      }).catch(error =>{
        console.log(error);
      })
    }

    }

   

  useEffect(() => {
    StudentService.getStudentById(sid).then((Response)=>{
      setsName(Response.data.sName)
      setsGrade(Response.data.sGrade)
      setsAddress(Response.data.sAddress)
    }).catch(error =>{
      console.log(error)
    })
    
  },[])

  const title =() =>{
    if(sid){
      return <h2 className='text-center'>Update Student</h2>
    }
    else{
      return <h2 className='text-center'>Add Student</h2>
    }
  }
  

    
  return (
    <div>
      <br/><br/>

      <div className='container'>
        <div className='row'>
          <div className='card col-md-6 offset-md-3 '>
            {
              title()
            }
          
            <div className='card-body'>
            <form>
              
              <div className='form-group mb-2'>
              <label className='form-label'>Name : </label>
              <input 
              type="text" name="sname" placeholder="Enter Student Name"
              className='form-control' value={sName} 
              onChange={(e) => setsName(e.target.value)}
              >
              </input>
              </div>
              <div className='form-group mb-2'>
                <label className='form-label'>Grade : </label>
                <input
                 type="text" name="sgrade" placeholder="Enter Student grade"
                 className='form-control' value={sGrade}
                 onChange={(e) => setsGrade(e.target.value)}
                 >
                </input>
             </div>
             
             <div className='form-group mb-2'>
              <label className='form-label' >Address :</label>
              <input
              type="text" name="saddress" placeholder="Enter Student Address"
              className='form-control' value={sAddress}
              onChange={(e) => setsAddress(e.target.value)}
              >
              </input>

             </div>

             <button className='btn btn-success' onClick={(e) => saveOrUpdateStudent(e)}>save</button> <br/><br/>
             <Link to="/students" className="btn btn-danger">cancel</Link>
            </form>

            </div>
            
          </div>

        </div>

      </div>
        
    </div>
  )
}

export default AddStudentComponent