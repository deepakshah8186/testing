import React, { useState } from 'react';

function PostFetcher() {
    const [post, setPost] = useState(null); // State to hold the fetched post
    const [loading, setLoading] = useState(false); // State to manage loading state
    const [error, setError] = useState(null); // State to manage errors

    // Function to fetch data on button click
    const fetchPost = () => {
        setLoading(true); // Set loading to true when starting to fetch
        setError(null); // Clear any previous errors
        fetch('https://jsonplaceholder.typicode.com/posts/1') // Fetch a single post
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Failed to fetch data'); // Handle HTTP errors
                }
                return response.json(); // Parse the response as JSON
            })
            .then((data) => {
                setPost(data); // Set the fetched post to state
                setLoading(false); // Set loading to false when done
            })
            .catch((error) => {
                setError(error.message); // Handle errors and set error message
                setLoading(false);
            });
    };

    return (
        <div>
            <h1>Fetch Post Data</h1>
            <button onClick={fetchPost}>Fetch Post</button>

            {loading && <p>Loading...</p>} {/* Show loading state */}
            {error && <p>Error: {error}</p>} {/* Show error if it occurs */}

            {post && ( /* Conditionally render post data once it's fetched */
                <div>
                    <h3>{post.title}</h3>
                    <p>{post.body}</p>
                </div>
            )}
        </div>
    );
}

export default PostFetcher;
