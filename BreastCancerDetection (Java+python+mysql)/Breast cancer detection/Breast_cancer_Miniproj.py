# -*- coding: utf-8 -*-
"""
Created on Sat Jan 26 13:33:36 2019

@author: Mukesh
"""


# Importing the libraries
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# Load Dataset
dataset = pd.read_csv('breast_cancer.csv')
X_test= pd.read_csv('patientTest.csv')
X_test= X_test.iloc[:,:-1 ].values
dataset=dataset.replace('?', np.NaN)
X = dataset.iloc[:,1:-1 ].values
y = dataset.iloc[:,-1].values

# Taking care of missing values 
from sklearn.preprocessing import Imputer
imputer= Imputer(missing_values="NaN",strategy="mean",axis=0)
X[:,:]=imputer.fit_transform(X[:,:])


# Splitting the dataset into the Training set and Test set
from sklearn.model_selection import train_test_split
X_train= X;
y_train= y;


# Feature Scaling
from sklearn.preprocessing import StandardScaler
sc = StandardScaler()
X_train = sc.fit_transform(X_train)
X_test = sc.transform(X_test)

# Applying Kernel PCA
from sklearn.decomposition import KernelPCA
kpca = KernelPCA(n_components = 2, kernel = 'rbf')
X_train = kpca.fit_transform(X_train)
X_test = kpca.transform(X_test)


# Fitting Kernel SVM to the Training set
from sklearn.svm import SVC
classifier = SVC(C=1,kernel = 'rbf', random_state = 0,gamma=0.1)
classifier.fit(X_train, y_train)



#Predicting the result
y_pred = classifier.predict(X_test)

outFileName="F:\\eclipse-workspace\\breastCancerDetection_Trial\\Breast cancer detection\\yPred.txt"
outFile=open(outFileName, "w")
outFile.write( str(y_pred[0]))
outFile.close()

print(y_pred[0])

"""
# Applying Grid Search to find the best model and the best parameters
from sklearn.model_selection import GridSearchCV
parameters = [{'C': [1, 10, 100, 1000], 'kernel': ['linear']},
              {'C': [1, 10, 100, 1000], 'kernel': ['rbf'], 'gamma': [0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9]}]
grid_search = GridSearchCV(estimator = classifier,
                           param_grid = parameters,
                           scoring = 'accuracy',
                           cv = 10,
                           n_jobs = -1)
grid_search = grid_search.fit(X_train, y_train)
best_accuracy = grid_search.best_score_
best_parameters = grid_search.best_params_

#K-fold cross Validation
from sklearn.model_selection import cross_val_score
accuracies=cross_val_score(estimator=classifier,X=X_train,y=y_train,cv=10)
accuracies.mean()
accuracies.std()

# Visualising the Training set results
from matplotlib.colors import ListedColormap
X_set, y_set = X_train, y_train
X1, X2 = np.meshgrid(np.arange(start = X_set[:, 0].min() - 1, stop = X_set[:, 0].max() + 1, step = 0.01),
                     np.arange(start = X_set[:, 1].min() - 1, stop = X_set[:, 1].max() + 1, step = 0.01))
plt.contourf(X1, X2, classifier.predict(np.array([X1.ravel(), X2.ravel()]).T).reshape(X1.shape),
             alpha = 0.75, cmap = ListedColormap(('green', 'red', 'blue')))
plt.xlim(X1.min(), X1.max())
plt.ylim(X2.min(), X2.max())
for i, j in enumerate(np.unique(y_set)):
    plt.scatter(X_set[y_set == j, 0], X_set[y_set == j, 1],
                c = ListedColormap(('green', 'red', 'blue'))(i), label = j)
plt.title('Breast Cancer Detector')
plt.xlabel('Dimention 1')
plt.ylabel('Dimention 2')
plt.legend()
plt.show()
"""

