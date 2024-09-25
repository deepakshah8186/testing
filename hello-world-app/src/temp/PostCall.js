import {useEffect, useState} from "react";

function PostList() {
    const [posts,setPosts] = useState([]);
    const [error,setError] = useState(null);
    const [loading,setLoading] = useState(false);

    useEffect(() => {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Failed to fetch data'); // Handle HTTP errors
                }
                return response.json(); // Parse the response as JSON
            })
            .then((data) => {
                setPosts(data); // Set the fetched posts to state
                setLoading(false); // Set loading to false
            })
            .catch((error) => {
                setError(error.message); // Handle errors and set error message
                setLoading(false);
            });
    }, []);

 if(error){
     return <p> Error: {error}</p>
 }


 return (
     <div>
         <h1>Posts data</h1>
         <ul>
             {
                 posts.map((title)=>{

                 })
             }
             {
                posts.map((title, key) => {
                    <h1>{title}</h1>
                    <h1>{key}</h1>})
             }
         </ul>
     </div>
 );

};

export default PostList