Create proc spFavoriteByYear(@Year INT)
AS
BEGIN
    SELECT 
        v.title AS 'GROUP',
        COUNT(f.id) AS 'Likes',
        MAX(f.LikeDate) AS 'Newest',
        MIN(f.LikeDate) AS 'Oldest'
    FROM 
        Favorites f
    JOIN 
        Videos v ON v.id = f.videoId
    WHERE 
        YEAR(f.likeDate) = @Year
    GROUP BY 
        v.Title;
END
