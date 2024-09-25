import {useState} from "react";


const  UsernameValidation = () => {

     const [username,setUsername] = useState('');
     const [error,setError] = useState('');

     const validate = (value) => {

         setUsername(value);
         if(value.length < 1){
             setError("my error");
             console.log("my error");
         } else {
             setError('');
             console.log("no error");
         }
     }

     const handleSubmit = (e) => {
         e.preventDefault();
         console.log("my handle submit");
         if(error){
             alert('Username is invalid');
         }
     }

     return (
         <div>
             <form onSubmit={handleSubmit}>
                <input type="text" value={username} onChange={(e) => validate(e.target.value)} />
             </form>
             {error}
             <button type="submit" > Submit</button>

         </div>
     );
}

export default UsernameValidation;