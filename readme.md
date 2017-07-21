# Sentiment Analysis System

## Purpose
This system includes a regression model which predicts the star of a movie review given the review text. Handcrafted features mainly including N-grams and POS tags are fed into GradientBoostingRegressor and SVR models.

## How to add features?
1. Define a class to implement FeatureExtractorInterface Interface
2. Invoke registerFeatureExtractor() of the class in setup method of FeatureExtractor class.

## Contributors
Qi Li
Liang Wang

## Contact
Email: qi.li7@mail.mcgill.ca