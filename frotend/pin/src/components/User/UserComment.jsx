import React from 'react';

const UserComment = ({ author, comment, date }) => {
  return (
    <div className="comment">
      <h3>{author} - {date}</h3>
      <p>{comment}</p>
    </div>
  );
};

export default UserComment;