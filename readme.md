SA
==========


Sentiment analysis for movie review.

如何增加特征？
===================
1. 写一个类实现FeatureExtractorInterface接口
2. 在FeatureExtractor中的setup方法中调用registerFeatureExtractor()方法注册


如何实现一个模型？
====================
写一个类实现Model接口，实现其中的predict(), train()方法。
